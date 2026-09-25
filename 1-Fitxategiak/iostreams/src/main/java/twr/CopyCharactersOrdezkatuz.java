package twr;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyCharactersOrdezkatuz {
    public static void main(String[] args) throws IOException {

        try (FileInputStream in = new FileInputStream("xanadu.txt");
            FileOutputStream out = new FileOutputStream("characteroutput.txt")) {   
{
            
            int c;
            while ((c = in.read()) != -1) {

                if (c == 'a') {
                    c = 'o';
                }

                out.write(c);
            }
        }
        }
    }
}