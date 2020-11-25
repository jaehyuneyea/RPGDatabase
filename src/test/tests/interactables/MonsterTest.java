package tests.interactables;

import model.interactables.MainCharacter;
import model.interactables.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {
    Monster monster;
    MainCharacter mc;

    @BeforeEach
    public void setup() {
        monster = new Monster("TestMonster",20,5);
        mc = new MainCharacter("TestPerson",20,10);
    }

    @Test
    public void testConstructor() {
        assertEquals("TestMonster",monster.getName());
    }

//    @Test
//    public void testMonsterAttack() {
//        monster.monsterAttack();
//        assertEquals(15,mc.getCurrentHP());
//    }
//
//    @Test
//    public void testMonsterAttackConsecutive() {
//        monster.monsterAttack();
//        monster.monsterAttack();
//        assertEquals(10,mc.getCurrentHP());
//    }

    @Test
    public void testGetIntent() {
        assertTrue(monster.getIntent());
    }
}
