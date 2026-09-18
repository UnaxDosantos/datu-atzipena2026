package paagbi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmantzipazioaEtaEtxebizitza {

    static class Erroldea {
        String adierazlea;
        String aldia;
        double balioa;
        String kategoria1;
        String kategoria1Balioa;

        public Erroldea(String adierazlea, String aldia, double balioa, String kategoria1, String kategoria1Balioa) {
            this.adierazlea = adierazlea;
            this.aldia = aldia;
            this.balioa = balioa;
            this.kategoria1 = kategoria1;
            this.kategoria1Balioa = kategoria1Balioa;
        }
    }

    public static void main(String[] args) {
        // BIDEA ZUZENKATUA
        String csvFitxategia = "C:/Users/dosantos.unax/Downloads/iovj-emancipacion.csv";
        List<Erroldea> erroldeak = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFitxategia))) {
            String lerroa;
            boolean lehenLerroa = true;

            while ((lerroa = br.readLine()) != null) {
                if (lehenLerroa) {
                    lehenLerroa = false;
                    continue;
                }

                String[] balioak = lerroa.split(";", -1);
                if (balioak.length >= 5) {
                    String adierazlea = balioak[0].replace("\"", "");
                    String aldia = balioak[1].replace("\"", "");
                    String balioaStr = balioak[2].replace("\"", "").replace(",", ".");
                    String kategoria1 = balioak[3].replace("\"", "");
                    String kategoria1Balioa = balioak[4].replace("\"", "");

                    try {
                        double balioa = Double.parseDouble(balioaStr);
                        erroldeak.add(new Erroldea(adierazlea, aldia, balioa, kategoria1, kategoria1Balioa));
                    } catch (NumberFormatException e) {
                        // Zenbaki ez diren balioak dituzten lerroak ez ikusi
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Errorea CSV fitxategia irakurtzean: " + e.getMessage());
            return;
        }

        // Datuak iragazi
        List<Erroldea> alokairua = new ArrayList<>();
        List<Erroldea> jabetza = new ArrayList<>();

        for (Erroldea r : erroldeak) {
            if (r.adierazlea.contains("Coste de acceso a la vivienda libre en alquiler")) {
                alokairua.add(r);
            } else if (r.adierazlea.contains("Coste de acceso a la vivienda libre en propiedad")) {
                jabetza.add(r);
            }
        }

        // Altxorrerako estatistikak erakutsi
        System.out.println("=== ALTXORREKO BIZITOKI LIBREARA SARTZEKO KOSTE BAINA ===");
        kalkulatuEtaErakutsiEstatistikak(alokairua);

        // Jabetzarako estatistikak erakutsi
        System.out.println("\n=== JABETZARAKO BIZITOKI LIBREARA SARTZEKO KOSTE BAINA ===");
        kalkulatuEtaErakutsiEstatistikak(jabetza);
    }

    private static void kalkulatuEtaErakutsiEstatistikak(List<Erroldea> erroldeak) {
        Map<String, Map<String, List<Double>>> datuakUrteLurraldeka = new HashMap<>();

        for (Erroldea r : erroldeak) {
            if (r.kategoria1Balioa.isEmpty() || r.kategoria1Balioa.equals("Total")) {
                continue;
            }

            String urtea = r.aldia;
            String lurraldea = r.kategoria1Balioa;

            datuakUrteLurraldeka
                .computeIfAbsent(urtea, k -> new HashMap<>())
                .computeIfAbsent(lurraldea, k -> new ArrayList<>())
                .add(r.balioa);
        }

        for (Map.Entry<String, Map<String, List<Double>>> urteEntry : datuakUrteLurraldeka.entrySet()) {
            String urtea = urteEntry.getKey();
            System.out.println("\nUrtea: " + urtea);

            for (Map.Entry<String, List<Double>> lurraldeEntry : urteEntry.getValue().entrySet()) {
                String lurraldea = lurraldeEntry.getKey();
                List<Double> balioak = lurraldeEntry.getValue();
                double batezbestekoa = balioak.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

                System.out.printf("  %s: %.2f\n", lurraldea, batezbestekoa);
            }
        }
    }
}