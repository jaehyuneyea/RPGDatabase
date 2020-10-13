package model.interactables;

public class MainCharacter extends CombatEntity {
    // should have health value, attack and defense and name and detail of the character
    // MAX_HEALTH

    // EFFECTS: creates a new Character with health, name attack and defense
    public MainCharacter(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
        // stub
    }


    // MODIFIES: Monster
    // EFFECTS: inflicts damage on the monster by atk - monster def
    public void characterAttack() {
        // stub
    }

    // EFFECTS: true if the character is already holding a weapon
    public Boolean isEquippedWeapon() {
        return false; // stub
    }

    // EFFECTS: true if character is already wearing armor
    public Boolean isEquippedArmor() {
        return false; // stub
    }

}
