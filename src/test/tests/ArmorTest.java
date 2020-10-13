package tests;

import model.interactables.MainCharacter;
import model.items.Armor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmorTest {
    Armor armor;
    MainCharacter c;

    @BeforeEach
    public void setup() {
        armor = new Armor("Cloth Armor","better than nothing.",10);
        c = new MainCharacter("Doug", 10,10,10);
    }

    @Test
    public void testConstructor() {
        assertEquals(10, armor.getDefenseItem());
        assertEquals("better than nothing.", armor.getDetail());

        assertEquals("Doug",c.getName());
        assertEquals(10,c.getHP());
        assertEquals(10, c.getAttack());
        assertEquals(10, c.getDefense());
    }

    @Test
    public void testAddArmor() {
        armor.addArmor();
        assertEquals(20,c.getDefense());
        assertEquals(10,c.getAttack());
        assertEquals(10,c.getHP());
    }

}
