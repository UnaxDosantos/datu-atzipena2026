
package paagbi;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class jsonFitxategiBatenIdatzi {

    public static void main(String[] args) throws IOException {

        JsonObject model = Json.createObjectBuilder()
                .add("menu", Json.createObjectBuilder()
                        .add("id", "file")
                        .add("value", "File"))
                .build();

        Path karpeta = Path.of("data");
        Files.createDirectories(karpeta);

        try (JsonWriter writer = Json.createWriterFactory(
                Map.of("jakarta.json.stream.JsonGenerator.prettyPrinting", true)
        ).createWriter(new FileOutputStream("data/Irteera.json"))) {
            writer.writeObject(model);
        }

        System.out.println("JSON fitxategia sortu da: data/Irteera.json");
    }
}