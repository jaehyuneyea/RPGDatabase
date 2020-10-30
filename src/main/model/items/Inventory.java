package model.items;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * an inventory that stores items and the main character can access.
 */

public class Inventory implements Writable {
    private List<Item> inventory;
    private String name;

    // EFFECTS: creates a new empty inventory
    public Inventory() {
        inventory = new LinkedList<>();
        name = "My Inventory";
    }

    // MODIFIES: this
    // EFFECTS: adds the item to the inventory
    public void addItem(Item i) {
        inventory.add(i);
    }

    public void clearInv() {
        inventory.clear();
    }

    // MODIFIES: this
    // EFFECTS: removes the item from the inventory
    public void throwAway(Item i) {
        inventory.remove(i);
    }


    // EFFECTS: returns the size of the inventory
    public int length() {                  // taken from lab 5
        return inventory.size();
    }

    // getters

    // REQUIRES: inventory must not be empty
    // EFFECTS: returns the item in position
    public String getItemNameInPosition(int position) {     // similar structure taken from lab 5
        return inventory.get(position).getName();

    }

    // EFFECTS: returns the list of all the item names in the inventory, empty if none
    public List<String> getInventoryName() {
        List<String> itemNames = new ArrayList<>();
        for (Item i : inventory) {
            itemNames.add(i.getName());
        }
        return itemNames;
    }

    public String getName() {
        return name;
    }

    // EFFECTS: get an unmodifiable list of items in the inventory
    public List<Item> getItems() {
        return Collections.unmodifiableList(inventory);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name",name);
        json.put("items",itemsToJson());
        return json;
    }

    private JSONArray itemsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Item i : inventory) {
            jsonArray.put(i.toJson());
        }

        return jsonArray;
    }
}
