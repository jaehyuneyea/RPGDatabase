package model.items;

public class HealthPotion extends Item {
    public static final int HEAL_VALUE = 10;

    // EFFECTS: creates a new Health potion with HEAL_VALUE
    public HealthPotion() {
        super("HealthPotion", "",false);
    }

    // MODIFIES: MainCharacter
    // EFFECTS: heals the player for HEAL_VALUE, stops healing at MAX_HEALTH
    public void healPotion() {
        // stub
    }

}
