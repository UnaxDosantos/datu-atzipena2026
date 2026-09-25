package nio;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ariketa1 {

    public static void main(String[] args) {
        System.out.println("Ariketa 1 martxan");

        Scanner sc = new Scanner(System.in);

        System.out.print("Sartu fitxategi edo direktorio baten path absolutua: ");
        String ruta = sc.nextLine();

        Path path = Paths.get(ruta);

        if (Files.exists(path)) {
            System.out.println("Path-a existitzen da.");

            if (Files.isDirectory(path)) {
                System.out.println("Direktorio bat da.");
            } else if (Files.isRegularFile(path)) {
                System.out.println("Fitxategi bat da.");
            }

        } else {
            System.out.println("Path-a ez da existitzen.");
        }

        sc.close();
    }
}