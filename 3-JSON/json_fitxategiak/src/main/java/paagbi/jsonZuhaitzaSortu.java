
package paagbi;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonWriter;

public class jsonZuhaitzaSortu {

    public static void main(String[] args) {

        JsonObject menu = Json.createObjectBuilder()
                .add("id", "file")
                .add("value", "File")
                .build();

        JsonObject model = Json.createObjectBuilder()
                .add("menu", menu)
                .build();

        try (JsonWriter writer = Json.createWriterFactory(
                java.util.Map.of("jakarta.json.stream.JsonGenerator.prettyPrinting", true)
        ).createWriter(System.out)) {
            writer.writeObject(model);
        }
    }
}