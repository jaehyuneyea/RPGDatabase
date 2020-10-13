package tests;

import model.interactables.MainCharacter;
import model.items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    Inventory inv;
    MainCharacter mc;
    HealthPotion item1;
    Weapon item2;
    Armor item3;

    @BeforeEach
    public void setup() {
        inv = new Inventory();
        mc = new MainCharacter("John",20,10,10);
        item1 = new HealthPotion();
        item2 = new WoodenSword();
        item3 = new Armor("Armor","nice",10);
    }

    @Test
    public void testConstructor() {
        assertEquals(0,inv.length());
    }

    @Test
    public void testAddItemOne() {
        inv.addItem(item1);
        assertEquals(1,inv.length());
        assertEquals("HealthPotion",inv.getItemNameInPosition(0));
    }

    @Test
    public void testAddItemMultiple() {
        inv.addItem(item1);
        inv.addItem(item2);
        inv.addItem(item3);
        assertEquals(3,inv.length());
        assertEquals("HealthPotion",inv.getItemNameInPosition(0));
        assertEquals("Armor",inv.getItemNameInPosition(2));
    }

    @Test
    public void testThrowAwayOne() {
        inv.addItem(item1);
        assertEquals(1,inv.length());
        inv.throwAway(item1);
        assertEquals("there is nothing there",inv.getItemNameInPosition(0));
    }

    @Test
    public void testThrowAwayMultiple() {
        inv.addItem(item1);
        inv.addItem(item2);
        inv.addItem(item3);
        assertEquals(3,inv.length());
        inv.throwAway(item1);
        inv.throwAway(item2);
        assertEquals(1, inv.length());
        assertEquals("Armor",inv.getItemNameInPosition(0));
    }

    @Test
    public void testEquip() {
        assertFalse(mc.isEquippedWeapon());
        inv.addItem(item2);
        assertTrue(inv.equip(item2));
        assertEquals(0, inv.length());
        assertEquals(20,mc.getAttack());
        assertTrue(mc.isEquippedWeapon());
    }

    @Test
    public void testEquipAlreadyEquipped() {
        inv.addItem(item2);
        inv.addItem(item2);
        assertTrue(inv.equip(item2));
        assertTrue(mc.isEquippedWeapon());
        assertEquals(1,inv.length());
        assertFalse(inv.equip(item2));
        assertEquals(1,inv.length());
    }

    @Test
    public void testEquipArmor() {
        inv.addItem(item3);
        assertTrue(inv.equip(item3));
        assertEquals(0,inv.length());
        assertEquals(20,mc.getDefense());
        assertTrue(mc.isEquippedArmor());
    }

    @Test
    public void testConsumeOne() {
        assertEquals(20,mc.getHP());
        mc.setHP(10);
        assertEquals(10,mc.getHP());
        inv.addItem(item1);
        inv.consume(item1);
        assertEquals(20,mc.getHP());
        assertEquals(0,inv.length());
    }

    @Test
    public void testConsumeMultiple() {
        assertEquals(20,mc.getHP());
        mc.setHP(1);
        assertEquals(1,mc.getHP());
        inv.addItem(item1);
        inv.addItem(item1);
        assertEquals(2,inv.length());
        inv.consume(item1);
        assertEquals(11,mc.getHP());
        assertEquals(1,inv.length());
        inv.consume(item1);
        assertEquals(20,mc.getHP());
        assertEquals(0,inv.length());
    }

    @Test
    public void testLengthNone() {
        assertEquals(0,inv.length());
    }

    @Test
    public void testLengthSome() {
        inv.addItem(item1);
        inv.addItem(item2);
        inv.addItem(item3);
        assertEquals(3,inv.length());
    }
}
