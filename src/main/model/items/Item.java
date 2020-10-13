package model.items;

public abstract class Item {


    // EFFECTS: creates a new item with name, detail and whether it's equippable or consumable
    // canEquip = false = consumable
    // canEquip = true = equippable
    public Item(String name, String detail, boolean canEquip) {
        // stub
    }

    public String getDetail() {
        return "";// stub
    }

    public String getName() {
        return "";
    }

    public boolean isEquippable() {
        return false;   // stub
    }

}
