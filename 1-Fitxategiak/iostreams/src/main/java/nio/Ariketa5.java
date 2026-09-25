package nio;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;

public class Ariketa5 {

    public static void main(String[] args) {

        JFileChooser aukeratzailea = new JFileChooser();

        aukeratzailea.setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY
        );

        aukeratzailea.setDialogTitle("Aukeratu karpeta bat");

        int aukera = aukeratzailea.showOpenDialog(null);

        if (aukera != JFileChooser.APPROVE_OPTION) {
            System.out.println("Ez duzu karpetarik aukeratu.");
            return;
        }

        Path karpeta = aukeratzailea
                .getSelectedFile()
                .toPath();

        Path fitxategia = karpeta.resolve("zerrenda.txt");

        try {

            StringBuilder edukia = new StringBuilder();

            try (DirectoryStream<Path> stream =
                         Files.newDirectoryStream(karpeta)) {

                for (Path path : stream) {

                    if (Files.isDirectory(path)) {
                        edukia.append("[KARPETA] ");
                    } else {
                        edukia.append("[FITXATEGIA] ");
                    }

                    edukia.append(path.getFileName());
                    edukia.append(System.lineSeparator());
                }
            }

            Files.writeString(fitxategia, edukia.toString());

            System.out.println("Fitxategia sortu da:");
            System.out.println(fitxategia.toAbsolutePath());

        } catch (IOException e) {

            System.out.println("Errorea: " + e.getMessage());
        }
    }
}