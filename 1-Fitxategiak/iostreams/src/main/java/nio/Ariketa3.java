package nio;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ariketa3 {

    public static void main(String[] args) {

        try {
            Path nio = Path.of(
                    Ariketa3.class
                            .getProtectionDomain()
                            .getCodeSource()
                            .getLocation()
                            .toURI()
            );

            nio = nio.getParent().getParent().getParent()
                    .resolve("src")
                    .resolve("main")
                    .resolve("java")
                    .resolve("nio");

            Path karpeta = nio.resolve("Karpeta_berriak");

            Files.createDirectories(
                    karpeta.resolve("Animaliak").resolve("arrainak")
            );

            Files.createDirectories(
                    karpeta.resolve("Animaliak").resolve("ugaztunak")
            );

            Files.createDirectories(
                    karpeta.resolve("Elikagaiak").resolve("barazkiak")
            );

            Files.createDirectories(
                    karpeta.resolve("Elikagaiak").resolve("esnekiak")
            );

            System.out.println("Karpeta-egitura prest dago.");
            System.out.println("Sortutako kokapena:");
            System.out.println(karpeta.toAbsolutePath());

        } catch (Exception e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }
}