import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Prueba {

    public static void main(String[] args) throws Exception {

        String url =
            "https://opendata.euskadi.eus/contenidos/estadistica/gazte_adierazle_emanc_vivienda/opendata/iovj-emancipacion.csv";

        URL direccion = new URL(url);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(direccion.openStream()))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
}