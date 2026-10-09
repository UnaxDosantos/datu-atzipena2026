
package paagbi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class jsonFitxategiaIrakurri {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(
                    new File("json_fitxategiak/menu.json")
            );

            System.out.println(root.toPrettyString());

            JsonNode menu = root.get("menu");

            System.out.println(menu.get("id").asText());
            System.out.println(menu.get("value").asText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}