package twr;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyCharactersMaiuskulaz {
    public static void main(String[] args) throws IOException {

        try (FileInputStream in = new FileInputStream("xanadu.txt");
            FileOutputStream  o= new FileOutputStream("characteroutput.txt")){
            

            int c;
            while ((c = in.read()) != -1) {

                c = Character.toUpperCase((char) c);

                o.write(c);
            }
        }
    }
}