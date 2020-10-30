package model.items;

import org.json.JSONObject;
import persistence.Writable;

/**
 * an object that the player can use and equip.
 */

public class Item implements Writable {
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

    public boolean isEquippable() {
        return canEquip;
    }

    // getters

    public String getDetail() {
        return detail;
    }

    public String getName() {
        return name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("detail", detail);
        json.put("canEquip", canEquip);
        return json;
    }
}
