package model.items;

import java.util.List;

public class Inventory {
    // a list of items the character is holding.

    // EFFECTS: creates a new empty inventory
    public Inventory() {

    }

    // MODIFIES: this
    // EFFECTS: adds the item to the inventory
    public void addItem(Item i) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: removes the item from the inventory
    public void throwAway(Item i) {
        // stub
    }

    // MODIFIES: MainCharacter, this
    // EFFECTS: equips the item onto the player and return true- item is removed from the inventory
    //          return false if already equipped
    public boolean equip(Equippable e) {
        return false;
    }

    // MODIFIES: MainCharacter, this
    // EFFECTS: consumes the item and receive its effects- item is removed from the inventory
    public void consume(HealthPotion hp) {
        //stub
    }

    // EFFECTS: returns the list of all the items in the inventory, empty if none
    public List<Item> getInventory() {
        return null; // stub
    }

    // EFFECTS: returns the size of the inventory
    public int length() {                  // taken from lab 5
        return 0; // stub
    }

    // EFFECTS: returns the name of the item in position
    //          return "there is nothing there" if no item is in that slot
    public String getItemNameInPosition(int position) {     // similar structure taken from lab 5
        return null; // stub
    }

}
