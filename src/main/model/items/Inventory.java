package model.items;

import model.interactables.MainCharacter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Item> inventory;

    // EFFECTS: creates a new empty inventory
    public Inventory() {
        inventory = new LinkedList<>();
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

}
