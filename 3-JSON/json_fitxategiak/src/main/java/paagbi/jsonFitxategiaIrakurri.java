
package paagbi;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import java.io.FileInputStream;
import java.io.InputStream;

public class jsonFitxategiaIrakurri {

    public static void main(String[] args) {

        try (InputStream is = new FileInputStream("json_fitxategiak/menu.json");
             JsonReader reader = Json.createReader(is)) {

            JsonObject model = reader.readObject();

            System.out.println(model);
            System.out.println(model.getJsonObject("menu").getString("id"));
            System.out.println(model.getJsonObject("menu").getString("value"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}