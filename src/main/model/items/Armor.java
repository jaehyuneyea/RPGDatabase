package model.items;

public class Armor extends Equippable {


    // EFFECTS: creates new Armor with defense stat and detail
    public Armor(String name, String detail, int def) {
        super(name,detail,0,def);

    }

    // REQUIRES: player must not already be wearing armor
    // MODIFIES: MainCharacter
    // EFFECTS: adds the defense stat given by the armor to the player
    public void addArmor() {
        // stub
    }

    public int getDefenseItem() {
        return 0; // stub
    }

}
