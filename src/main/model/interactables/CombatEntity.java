package model.interactables;

public abstract class CombatEntity {

    // EFFECTS: creates a new combat entity name, hp, attack and defense
    public CombatEntity(String name, int hp, int atk, int def) {

    }

    public int getHP() {
        return 0;
    }

    public int getAttack() {
        return 0;
    }

    public int getDefense() {
        return 0;
    }

    public String getName() {
        return null;
    }

    // REQUIRES: 0 < hp < MAX_HEALTH
    // MODIFIES: this
    // EFFECTS: sets the character's hp to the value
    public int setHP(int hp) {
        return 0;
    }

    // EFFECTS: true if MainCharacter HP > 0
    //          false otherwise
    public boolean isAlive() {
        return false;
    }
}
