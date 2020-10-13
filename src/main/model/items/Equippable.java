package model.items;

public abstract class Equippable extends Item {
    // FIELDS: type of equip (pants, upper torsowear, weapon

    public Equippable(String name, String detail, int atk, int def) {
        super(name, detail, true);
    }
}
