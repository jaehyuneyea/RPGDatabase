package model.interactables;

/**
 * represents a slime monster within the game
 */

public class Slime extends Monster {
    protected String detail;

    public Slime() {
        super("Slime", 10, 1);
        this.detail = "A squishy, green slime. Hostile but really harmless.";
    }

    // getters

    public String getDetail() {
        return detail;
    }
}
