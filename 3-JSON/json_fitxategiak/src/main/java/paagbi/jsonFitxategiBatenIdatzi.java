
package paagbi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class jsonFitxategiBatenIdatzi {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            ObjectNode menu = mapper.createObjectNode();
            menu.put("id", "file");
            menu.put("value", "File");

            ObjectNode root = mapper.createObjectNode();
            root.set("menu", menu);

            File carpeta = new File("data");
            carpeta.mkdirs();

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(carpeta, "Irteera.json"), root);

            System.out.println("Fitxategia behar bezala gorde da.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}