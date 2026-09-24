package OpenData;

import java.net.URI;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmantzipazioaEtaEtxebizitza {

    static class Erroldea {

        String adierazlea;
        String aldia;
        double balioa;
        String kategoria1;
        String kategoria1Balioa;

        public Erroldea(
                String adierazlea,
                String aldia,
                double balioa,
                String kategoria1,
                String kategoria1Balioa) {

            this.adierazlea = adierazlea;
            this.aldia = aldia;
            this.balioa = balioa;
            this.kategoria1 = kategoria1;
            this.kategoria1Balioa = kategoria1Balioa;
        }
    }

    public static void main(String[] args) {

        String csvFitxategia =
                "file:///C:/Users/dosantos.unax/Downloads/iovj-emancipacion.csv";

        List<Erroldea> erroldeak = new ArrayList<>();

        // ==========================================
        // CSV FITXATEGIA IRAKURRI
        // ==========================================

        try {

            URI uri = URI.create(csvFitxategia);
            URL url = uri.toURL();

            try (BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(
                                    url.openStream()))) {

                String lerroa;
                boolean lehenLerroa = true;

                while ((lerroa = br.readLine()) != null) {

                    // Lehenengo lerroa goiburua da
                    if (lehenLerroa) {
                        lehenLerroa = false;
                        continue;
                    }

                    String[] balioak =
                            lerroa.split(";", -1);

                    if (balioak.length >= 5) {

                        String adierazlea =
                                balioak[0].replace("\"", "");

                        String aldia =
                                balioak[1].replace("\"", "");

                        String balioaStr =
                                balioak[2]
                                        .replace("\"", "")
                                        .replace(",", ".");

                        String kategoria1 =
                                balioak[3].replace("\"", "");

                        String kategoria1Balioa =
                                balioak[4].replace("\"", "");

                        try {

                            double balioa =
                                    Double.parseDouble(balioaStr);

                            erroldeak.add(
                                    new Erroldea(
                                            adierazlea,
                                            aldia,
                                            balioa,
                                            kategoria1,
                                            kategoria1Balioa
                                    )
                            );

                        } catch (NumberFormatException e) {
                            // Ez bada zenbakia, ez dugu kontuan hartuko
                        }
                    }
                }
            }

        } catch (IOException e) {

            System.err.println(
                    "Errorea CSV fitxategia irakurtzean: "
                            + e.getMessage()
            );

            return;
        }

        // ==========================================
        // DATUAK BANATU
        // ==========================================

        List<Erroldea> alokairua =
                new ArrayList<>();

        List<Erroldea> jabetza =
                new ArrayList<>();

        for (Erroldea r : erroldeak) {

            if (r.adierazlea.contains(
                    "Coste de acceso a la vivienda libre en alquiler")) {

                alokairua.add(r);

            } else if (r.adierazlea.contains(
                    "Coste de acceso a la vivienda libre en propiedad")) {

                jabetza.add(r);
            }
        }

        // ==========================================
        // MENU NAGUSIA
        // ==========================================

        Scanner scanner = new Scanner(System.in);

        int aukera = 0;

        while (aukera != 4) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("       EMANTZIPAZIOA ETA ETXEBIZITZA");
            System.out.println("========================================");
            System.out.println();
            System.out.println("  1. Alokairuko datuak ikusi");
            System.out.println("  2. Jabetzako datuak ikusi");
            System.out.println("  3. Datu guztiak ikusi");
            System.out.println("  4. Irten");
            System.out.println();
            System.out.print("Aukeratu aukera bat: ");

            try {

                aukera = scanner.nextInt();

            } catch (Exception e) {

                scanner.nextLine();

                System.out.println();
                System.out.println(
                        "Aukera ez da zuzena."
                );

                continue;
            }

            System.out.println();

            switch (aukera) {

                case 1:

                    System.out.println(
                            "========================================"
                    );

                    System.out.println(
                            "       ALOKAIRUKO ETXEBIZITZA"
                    );

                    System.out.println(
                            "========================================"
                    );

                    kalkulatuEtaErakutsiEstatistikak(
                            alokairua
                    );

                    break;

                case 2:

                    System.out.println(
                            "========================================"
                    );

                    System.out.println(
                            "       JABETZAKO ETXEBIZITZA"
                    );

                    System.out.println(
                            "========================================"
                    );

                    kalkulatuEtaErakutsiEstatistikak(
                            jabetza
                    );

                    break;

                case 3:

                    System.out.println(
                            "========================================"
                    );

                    System.out.println(
                            "       ALOKAIRUKO ETXEBIZITZA"
                    );

                    System.out.println(
                            "========================================"
                    );

                    kalkulatuEtaErakutsiEstatistikak(
                            alokairua
                    );

                    System.out.println();

                    System.out.println(
                            "========================================"
                    );

                    System.out.println(
                            "       JABETZAKO ETXEBIZITZA"
                    );

                    System.out.println(
                            "========================================"
                    );

                    kalkulatuEtaErakutsiEstatistikak(
                            jabetza
                    );

                    break;

                case 4:

                    System.out.println(
                            "Programa amaitu da."
                    );

                    break;

                default:

                    System.out.println(
                            "Aukera ez da zuzena. "
                                    + "1 eta 4 arteko zenbaki bat aukeratu."
                    );
            }

            if (aukera != 4) {

                System.out.println();
                System.out.println(
                        "Sakatu ENTER menu nagusira itzultzeko..."
                );

                scanner.nextLine();
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // ==========================================
    // ESTATISTIKAK KALKULATU ETA ERAKUTSI
    // ==========================================

    private static void kalkulatuEtaErakutsiEstatistikak(
            List<Erroldea> erroldeak) {

        Map<String, Map<String, List<Double>>>
                datuakUrteLurraldeka =
                new HashMap<>();

        for (Erroldea r : erroldeak) {

            if (r.kategoria1Balioa.isEmpty()
                    || r.kategoria1Balioa.equals("Total")) {

                continue;
            }

            String urtea = r.aldia;

            String lurraldea =
                    r.kategoria1Balioa;

            datuakUrteLurraldeka
                    .computeIfAbsent(
                            urtea,
                            k -> new HashMap<>()
                    )
                    .computeIfAbsent(
                            lurraldea,
                            k -> new ArrayList<>()
                    )
                    .add(r.balioa);
        }

        for (Map.Entry<String, Map<String, List<Double>>>
                urteEntry :
                datuakUrteLurraldeka.entrySet()) {

            String urtea =
                    urteEntry.getKey();

            System.out.println();
            System.out.println(
                    "Urtea: " + urtea
            );

            System.out.println(
                    "----------------------------------------"
            );

            for (Map.Entry<String, List<Double>>
                    lurraldeEntry :
                    urteEntry.getValue().entrySet()) {

                String lurraldea =
                        lurraldeEntry.getKey();

                List<Double> balioak =
                        lurraldeEntry.getValue();

                double batezbestekoa =
                        balioak.stream()
                                .mapToDouble(
                                        Double::doubleValue
                                )
                                .average()
                                .orElse(0.0);

                System.out.printf(
                        "  %-20s : %.2f%n",
                        lurraldea,
                        batezbestekoa
                );
            }
        }
    }
}