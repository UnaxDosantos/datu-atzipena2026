package nio;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ariketa4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Zer zoaz deskribatzera? ");
        String mota = sc.nextLine();

        System.out.print("Zein? ");
        String izena = sc.nextLine();

        System.out.print("Nolakoa da? ");
        String deskribapena = sc.nextLine();

        try {

            Path rutaActual = Path.of(
                    Ariketa4.class
                            .getProtectionDomain()
                            .getCodeSource()
                            .getLocation()
                            .toURI()
            );

            Path nio = rutaActual
                    .getParent()
                    .getParent()
                    .resolve("src")
                    .resolve("main")
                    .resolve("java")
                    .resolve("nio");

            Path karpeta = nio
                    .resolve("Karpeta_berriak")
                    .resolve("Animaliak")
                    .resolve(mota);

            Files.createDirectories(karpeta);

            Path fitxategia = karpeta.resolve(izena + ".txt");

            Files.writeString(fitxategia, deskribapena);

            System.out.println();
            System.out.println("Fitxategia sortu da:");
            System.out.println(fitxategia.toAbsolutePath());

        } catch (Exception e) {

            System.out.println("Errorea: " + e.getMessage());

        }

    }
}