package model.interactables;

import model.items.HealthPotion;
import model.items.Inventory;
import model.items.Weapon;

/**
 * represents the MainCharacter that you control within the game.
 */

public class MainCharacter extends CombatEntity {
    protected boolean equipW;
    protected Inventory inventory;
    protected String currentlyEquipped;


    // EFFECTS: creates a new Character with health, name attack and defense with wooden sword and no items
    public MainCharacter(String name, int health, int attack) {
        super(name, health, attack);
        inventory = new Inventory();
        currentlyEquipped = "none";
    }


    // MODIFIES: Monster
    // EFFECTS: inflicts damage on the monster by atk
//    public void characterAttack() {
    // stub // TODO: come back to this one
//    }

    // MODIFIES: this
    // EFFECTS: adds attack value to the character
    public void addAttack(int atk) {
        attack = attack + atk;
    }

    // MODIFIES: this
    // EFFECTS: heals the character by 1
    public void heal() {
        currentHealth = currentHealth + 1;
    }

    // EFFECTS: true if the character is already holding a weapon
    public boolean isEquippedWeapon() {
        return equipW;
    }

    // REQUIRES: item is already in inventory
    // MODIFIES: this
    // EFFECTS: equips the item onto the player and return true
    //          return false if already equipped
    public boolean equip(Weapon w) {
        if (!(isEquippedWeapon())) {
            w.addWeapon(this);
            setCurrentlyEquipped(w);
            equipW = true;
            return true;
        }
        return false;
    }

    // REQUIRES: item is already in inventory
    // MODIFIES: this
    // EFFECTS: consumes the item and receive its effects
    public void consume(HealthPotion hp) {
        hp.healPotion(this);
        inventory.throwAway(hp);
        // TODO: as of right now, the potion is not removed from the inventory when consumed.
        // fix this later by having inventory be part of the MainCharacter class?
    }

    // setters

    // EFFECTS: gives the weapon inserted to the main character
    public void setCurrentlyEquipped(Weapon w) {
        this.currentlyEquipped = w.getName();
    }

    // getters

    // EFFECTS: returns the name of the weapon the character is holding
    public String getCurrentlyEquipped() {
        if (currentlyEquipped.equals("none")) {
            return "None";
        }
        return currentlyEquipped;
    }
}
