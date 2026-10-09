
package paagbi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class jsonZuhaitzaSortu {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode menu = mapper.createObjectNode();
        menu.put("id", "file");
        menu.put("value", "File");

        ObjectNode root = mapper.createObjectNode();
        root.set("menu", menu);

        System.out.println(root.toPrettyString());
    }
}