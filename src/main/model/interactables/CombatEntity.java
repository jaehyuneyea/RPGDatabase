package model.interactables;

public abstract class CombatEntity {
    protected String name;
    protected int maxHealth;
    protected int currentHealth;
    protected int attack;

    // EFFECTS: creates a new combat entity name, hp, attack and defense
    public CombatEntity(String name, int health, int attack) {
        this.name = name;
        this.maxHealth = health;
        this.attack = attack;
        this.currentHealth = health;

    }

    public String getName() {
        return name;
    }

    // EFFECTS: true if MainCharacter HP > 0
    //          false otherwise
    public boolean isAlive() {
        return currentHealth > 0;
    }

    // setters

    // REQUIRES: 0 < hp < MAX_HEALTH
    // MODIFIES: this
    // EFFECTS: sets the character's hp to the value
    public void setHP(int hp) {
        currentHealth = hp;
    }

    // getters

    public int getCurrentHP() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }
}
