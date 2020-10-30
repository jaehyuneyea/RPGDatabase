package model.items;

/**
 * a wooden sword weapon that the main character can equip.
 */

public class WoodenSword extends Weapon {
    public static final int WS_ATTACK_VALUE = 10;
    private static final String WS_DETAIL = "A frail, weak wooden sword.";
    // private String detail = "";


    // EFFECTS: constructs a new wooden sword with WS_ATTACK_VALUE and WS_DETAIL
    public WoodenSword() {
        super("Wooden Sword",WS_DETAIL,WS_ATTACK_VALUE);

    }

}
