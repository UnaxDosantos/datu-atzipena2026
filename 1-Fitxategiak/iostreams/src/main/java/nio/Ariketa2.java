package nio;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ariketa2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Sartu karpetaren path-a: ");
        String ruta = sc.nextLine();

        Path karpeta = Paths.get(ruta);

        if (!Files.exists(karpeta)) {
            System.out.println("Karpeta ez da existitzen.");
            sc.close();
            return;
        }

        if (!Files.isDirectory(karpeta)) {
            System.out.println("Sartutako path-a ez da karpeta bat.");
            sc.close();
            return;
        }

        System.out.println("\nKarpeta barruko edukia:");

        try (DirectoryStream<Path> edukia = Files.newDirectoryStream(karpeta)) {

            for (Path path : edukia) {
                System.out.println(path.getFileName());
            }

        } catch (IOException e) {
            System.out.println("Errorea: " + e.getMessage());
        }

    }
}