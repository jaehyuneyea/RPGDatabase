package model.items;

import model.interactables.MainCharacter;

/**
 * a health potion item that the main character can consume.
 */

public class HealthPotion extends Item {
    public static final int HEAL_VALUE = 10;
    private String detail = "A bottle containing a magical potion. Heals the user for 10 HP.";

    // EFFECTS: creates a new Health potion with HEAL_VALUE
    public HealthPotion() {
        super("HealthPotion", "",false);
        super.detail = detail;
    }

    // MODIFIES: MainCharacter
    // EFFECTS: heals the player for HEAL_VALUE, stops healing at MAX_HEALTH
    public void healPotion(MainCharacter mc) {
        for (int i = 0; i < HEAL_VALUE; i++) {
            if (mc.getCurrentHP() < mc.getMaxHealth()) {
                mc.heal();
            }
        }
    }

}
