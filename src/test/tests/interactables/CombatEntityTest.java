package tests.interactables;

import model.interactables.CombatEntity;
import model.interactables.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombatEntityTest {
    CombatEntity testEntity;

    @BeforeEach
    public void setup() {
        testEntity = new Monster("TestMonster",20,5);
    }

    @Test
    public void testConstructor() {
        assertEquals(20,testEntity.getCurrentHP());
        assertEquals(5,testEntity.getAttack());
        assertEquals("TestMonster",testEntity.getName());
        assertEquals(20, testEntity.getMaxHealth());
    }

    @Test
    public void testIsAlive() {
        assertTrue(testEntity.isAlive());
        testEntity.setHP(0);
        assertFalse(testEntity.isAlive());
    }

}
