package tests;

import model.interactables.MainCharacter;
import model.interactables.Monster;
import model.items.Armor;
import model.items.Inventory;
import model.items.Item;
import model.items.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainCharacterTest {
    Monster monster;
    MainCharacter mc;
    Inventory inv;
    Weapon item1;
    Armor item2;

    @BeforeEach
    public void setup() {
        monster = new Monster("TestMonster", 20, 5, 5);
        mc = new MainCharacter("TestPerson", 20, 10, 0);
        inv = new Inventory();
        item1 = new Weapon("sword","a test sword",10);
        item2 = new Armor("armor", "a test armor", 10);
    }

    @Test
    public void testIsEquippedWeapon() {
        assertFalse(mc.isEquippedWeapon());
        inv.addItem(item1);
        inv.equip(item1);
        assertTrue(mc.isEquippedWeapon());
    }

    @Test
    public void testIsEquippedArmor() {
        assertFalse(mc.isEquippedArmor());
        inv.addItem(item2);
        inv.equip(item2);
        assertFalse(mc.isEquippedArmor());
    }

    @Test
    public void testCharacterAttackOnce() {
        assertEquals(20,monster.getHP());
        mc.characterAttack();
        assertEquals(15, monster.getHP());
    }

    @Test
    public void testCharacterAttackMultiple() {
        assertEquals(20, monster.getHP());
        mc.characterAttack();
        mc.characterAttack();
        assertEquals(10,monster.getHP());
    }
}
