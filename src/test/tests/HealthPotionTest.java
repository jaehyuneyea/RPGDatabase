package tests;

import model.interactables.MainCharacter;
import model.items.HealthPotion;
import model.items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HealthPotionTest {
    HealthPotion hp;
    MainCharacter mc;

    @BeforeEach
    public void setup() {
        hp = new HealthPotion();
        mc = new MainCharacter("Phil",20,10,10);
    }

    @Test
    public void testConstructor() {
        assertEquals("HealthPotion",hp.getName());
        assertEquals("heals the user for 10 HP", hp.getDetail());
        assertFalse(hp.isEquippable());
    }

    @Test
    public void testHealPotion() {
        mc.setHP(10);
        assertEquals(10, mc.getHP());
        hp.healPotion();
        assertEquals(20,mc.getHP());
    }

    @Test
    public void testHealPotionFull() {
        mc.setHP(13);
        assertEquals(13,mc.getHP());
        hp.healPotion();
        assertEquals(20, mc.getHP());
    }

    @Test
    public void testHealPotionNotFull() {
        mc.setHP(7);
        assertEquals(7,mc.getHP());
        hp.healPotion();
        assertEquals(17,mc.getHP());
    }


}
