package model.interactables;

public class Monster extends CombatEntity {
    // should probably have health value, attack value and defense value (dependant on the mob)
    // abilities??
    // monster name, detail of the mob


    // EFFECTS: creates new Monster with HP, attack and defense
    public Monster(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
        // stub add detail
    }

    // MODIFIES: character
    // EFFECTS: inflicts damage on the character of atk amount - main character defense
    public void monsterAttack(){
        // stub
    }

    public String getDetail() {
        return null;    // stub
    }




}
