
package paagbi;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonWriter;
import java.util.Map;

public class jsonZuhaitzaSortuBi {

    public static void main(String[] args) {

        JsonObject berria = Json.createObjectBuilder()
                .add("value", "New")
                .add("onclick", "CreateNewDoc()")
                .build();

        JsonObject ireki = Json.createObjectBuilder()
                .add("value", "Open")
                .add("onclick", "OpenDoc()")
                .build();

        JsonObject itxi = Json.createObjectBuilder()
                .add("value", "Close")
                .add("onclick", "CloseDoc()")
                .build();

        JsonArray menuitem = Json.createArrayBuilder()
                .add(berria)
                .add(ireki)
                .add(itxi)
                .build();

        JsonObject popup = Json.createObjectBuilder()
                .add("menuitem", menuitem)
                .build();

        JsonObject menu = Json.createObjectBuilder()
                .add("id", "file")
                .add("value", "File")
                .add("popup", popup)
                .build();

        JsonObject model = Json.createObjectBuilder()
                .add("menu", menu)
                .build();

        try (JsonWriter writer = Json.createWriterFactory(
                Map.of("jakarta.json.stream.JsonGenerator.prettyPrinting", true)
        ).createWriter(System.out)) {
            writer.writeObject(model);
        }
    }
}