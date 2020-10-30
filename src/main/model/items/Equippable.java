package model.items;

/**
 * represents items that the player can equip.
 */

public abstract class Equippable extends Item {
    // FIELDS: type of equip (pants, upper torsowear, weapon

    public Equippable(String name, String detail, int atk) {
        super(name, detail, true);
    }
}
