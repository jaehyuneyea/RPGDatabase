package model.interactables;

/**
 * represents the enemy that the MainCharacter fights, tries to kill the MainCharacter.
 */

public class Monster extends CombatEntity {
    // should probably have health value, attack value (dependant on the mob)
    // abilities??
    // monster name, detail of the mob


    // EFFECTS: creates new Monster with HP, attack and defense
    public Monster(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    @Override
    public boolean getIntent() {
        return true;
    }

    // MODIFIES: character
    // EFFECTS: inflicts damage on the character of atk amount
//    public void monsterAttack(){
        // TODO: come back to this one
//    }




}
