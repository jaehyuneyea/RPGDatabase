package persistence;


import model.items.Inventory;
import model.items.Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in a file
// model designed after https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads inventory from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Inventory read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseInventory(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses inventory from JSON object and returns it
    private Inventory parseInventory(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Inventory i = new Inventory();
        addItems(i,jsonObject);
        return i;
    }

    // MODIFIES: i
    // EFFECTS: parses items from JSON object and adds them to inventory
    private void addItems(Inventory i, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(i, nextItem);
        }
    }

    // MODIFIES: i
    // EFFECTS: parses item from JSON object and adds it to inventory
    private void addItem(Inventory i, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String detail = jsonObject.getString("detail");
        Boolean canEquip = jsonObject.getBoolean("canEquip");
        Item item = new Item(name, detail, canEquip);
        i.addItem(item);
    }
}
