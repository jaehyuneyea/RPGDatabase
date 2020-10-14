package model.items;

import model.interactables.MainCharacter;

public class Weapon extends Equippable {
    protected int atk;

    // TODO: create different types of Weapon with attack stat and detail, type of weapon
    // sword = 0
    // gloves = 1
    // staff = 2
    public Weapon(String name, String detail, int atk) {
        super(name, detail, atk);
        this.atk = atk;

    }

    // REQUIRES: character is not already holding a weapon
    // MODIFIES: MainCharacter
    // EFFECTS: adds the stats given from the item to the player
    public void addWeapon(MainCharacter mc) {
        mc.addAttack(atk);
    }

    // getters
    public int getAttackItem() {
        return atk;
    }

}
