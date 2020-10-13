package model.items;

public abstract class Item {
    protected String name;
    protected String detail;
    protected boolean canEquip;


    // EFFECTS: creates a new item with name, detail and whether it's equippable or consumable
    // canEquip = false = consumable
    // canEquip = true = equippable
    public Item(String name, String detail, boolean canEquip) {
        this.name = name;
        this.detail = detail;
        this.canEquip = canEquip;
    }

    public String getDetail() {
        return detail;
    }

    public String getName() {
        return name;
    }

    public boolean isEquippable() {
        return canEquip;
    }

}
