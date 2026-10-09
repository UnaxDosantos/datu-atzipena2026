
package paagbi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class jsonZuhaitzaSortuBi {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode root = mapper.createObjectNode();
        ObjectNode menu = mapper.createObjectNode();
        ObjectNode popup = mapper.createObjectNode();

        ArrayNode menuitem = mapper.createArrayNode();

        ObjectNode berria = mapper.createObjectNode();
        berria.put("value", "New");
        berria.put("onclick", "CreateNewDoc()");
        menuitem.add(berria);

        ObjectNode ireki = mapper.createObjectNode();
        ireki.put("value", "Open");
        ireki.put("onclick", "OpenDoc()");
        menuitem.add(ireki);

        ObjectNode itxi = mapper.createObjectNode();
        itxi.put("value", "Close");
        itxi.put("onclick", "CloseDoc()");
        menuitem.add(itxi);

        popup.set("menuitem", menuitem);

        menu.put("id", "file");
        menu.put("value", "File");
        menu.set("popup", popup);

        root.set("menu", menu);

        System.out.println(root.toPrettyString());

        System.out.println(
                root.get("menu")
                    .get("popup")
                    .get("menuitem")
                    .get(0)
                    .get("value")
                    .asText()
        );
    }
}