package tests.interactables;

import model.interactables.MainCharacter;
import model.interactables.Monster;
import model.items.HealthPotion;
import model.items.Inventory;
import model.items.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainCharacterTest {
    Monster monster;
    MainCharacter mc;
    MainCharacter mc2;
    Inventory inv;
    Weapon item1;
    HealthPotion item2;

    @BeforeEach
    public void setup() {
        monster = new Monster("TestMonster", 20, 5);
        mc = new MainCharacter("TestPerson", 20, 10);
        mc2 = new MainCharacter("NoEquip",10,10);
        inv = new Inventory();
        item1 = new Weapon("sword","a test sword",10);
        item2 = new HealthPotion();
    }

    @Test
    public void testIsEquippedWeapon() {
        assertFalse(mc.isEquippedWeapon());
        inv.addItem(item1);
        mc.equip(item1);
        assertTrue(mc.isEquippedWeapon());
        assertEquals("None",mc2.getCurrentlyEquipped());
        assertEquals("sword",mc.getCurrentlyEquipped());
    }


//    @Test
//    public void testCharacterAttackOnce() {
//        assertEquals(20,monster.getCurrentHP());
//        mc.characterAttack();
//        assertEquals(10, monster.getCurrentHP());
//    }

//    @Test
//    public void testCharacterAttackMultiple() {
//        assertEquals(20, monster.getCurrentHP());
//        mc.characterAttack();
//        mc.characterAttack();
//        assertEquals(10,monster.getCurrentHP());
//    }

    @Test
    public void addAttack() {
        assertEquals(10,mc.getAttack());
        mc.addAttack(10);
        assertEquals(20,mc.getAttack());
    }

    @Test
    public void testHeal() {
        assertEquals(20, mc.getCurrentHP());
        mc.setHP(10);
        assertEquals(10,mc.getCurrentHP());
        mc.heal();
        assertEquals(11,mc.getCurrentHP());
    }

    @Test
    public void testEquip() {
        inv.addItem(item1);
        assertTrue(mc.equip(item1));
        assertTrue(mc.isEquippedWeapon());
    }

    @Test
    public void testEquipAlreadyEquipped() {
        inv.addItem(item1);
        inv.addItem(item1);
        assertTrue(mc.equip(item1));
        assertTrue(mc.isEquippedWeapon());
        assertEquals(2,inv.length());
        assertFalse(mc.equip(item1));
        assertEquals(2,inv.length());
    }

    @Test
    public void testConsumeOne() {
        assertEquals(20,mc.getCurrentHP());
        mc.setHP(10);
        assertEquals(10,mc.getCurrentHP());
        inv.addItem(item2);
        mc.consume(item2);
        assertEquals(20,mc.getCurrentHP());
        assertEquals(1,inv.length());
    }

    @Test
    public void testConsumeMultiple() {
        assertEquals(20,mc.getCurrentHP());
        mc.setHP(1);
        assertEquals(1,mc.getCurrentHP());
        inv.addItem(item2);
        inv.addItem(item2);
        assertEquals(2,inv.length());
        mc.consume(item2);
        assertEquals(11,mc.getCurrentHP());
        assertEquals(2,inv.length());
        mc.consume(item2);
        assertEquals(20,mc.getCurrentHP());
        assertEquals(2,inv.length());
    }

    @Test
    public void testSetCurrentlyEquipped() {
        mc.setCurrentlyEquipped(item1);
        assertEquals("sword", mc.getCurrentlyEquipped());
    }
}
