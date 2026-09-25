package nio;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ariketa6 {

    public static void main(String[] args) {

        Path karpeta = Path.of(
                "src",
                "main",
                "java",
                "nio",
                "Karpeta_berriak"
        );

        try {

            fitxategiakAldatu(karpeta);

            System.out.println("Fitxategien izenak aldatu dira.");

        } catch (IOException e) {

            System.out.println("Errorea: " + e.getMessage());

        }
    }

    public static void fitxategiakAldatu(Path karpeta)
            throws IOException {

        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(karpeta, "*.txt")) {

            for (Path fitxategia : stream) {

                String izena = fitxategia.getFileName().toString();

                if (!izena.isEmpty()) {

                    String izenBerria =
                            Character.toUpperCase(izena.charAt(0))
                            + izena.substring(1);

                    Path fitxategiBerria =
                            fitxategia.resolveSibling(izenBerria);

                    if (!fitxategia.equals(fitxategiBerria)) {
                        Files.move(fitxategia, fitxategiBerria);
                    }
                }
            }
        }

        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(karpeta)) {

            for (Path path : stream) {

                if (Files.isDirectory(path)) {

                    fitxategiakAldatu(path);
                }
            }
        }
    }
}