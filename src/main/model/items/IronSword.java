package model.items;

/**
 * a iron sword weapon within the game.
 */

public class IronSword extends Weapon {
    public static final int IS_ATTACK_VALUE = 30;
    private static final String IS_DETAIL = "A well-built sturdy sword composed of iron.";
    // private String detail = "";


    // EFFECTS: constructs a new iron sword with IS_ATTACK_VALUE and IS_DETAIL
    public IronSword() {
        super("Iron Sword",IS_DETAIL,IS_ATTACK_VALUE);

    }

}
