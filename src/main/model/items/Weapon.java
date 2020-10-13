package model.items;

public class Weapon extends Equippable {

    // TODO: create different types of Weapon with attack stat and detail, type of weapon
    // sword = 0
    // gloves = 1
    // staff = 2
    public Weapon(String name, String detail, int atk) {
        super(name,detail,atk,0);

    }

    // REQUIRES: character is not already holding a weapon
    // MODIFIES: MainCharacter
    // EFFECTS: adds the stats given from the item to the player
    public void addWeapon() {
        // stub
    }

    public int getAttackItem() {
        return 0;
    }

    @Override
    public String getDetail() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

}
