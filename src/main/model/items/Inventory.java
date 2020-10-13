package model.items;

import model.interactables.MainCharacter;

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

    // MODIFIES: this
    // EFFECTS: removes the item from the inventory
    public void throwAway(Item i) {
        inventory.remove(i);
    }

    // EFFECTS: returns the list of all the items in the inventory, empty if none
    public List<Item> getInventory() {
        return inventory;
    }

    // EFFECTS: returns the size of the inventory
    public int length() {                  // taken from lab 5
        return inventory.size();
    }


    // REQUIRES: inventory must not be empty
    // EFFECTS: returns the item in position
    public String getItemNameInPosition(int position) {     // similar structure taken from lab 5
        return inventory.get(position).getName();

    }

}
