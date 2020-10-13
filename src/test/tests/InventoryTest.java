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

    @BeforeEach
    public void setup() {
        inv = new Inventory();
        mc = new MainCharacter("John",20,10);
        item1 = new HealthPotion();
        item2 = new WoodenSword();
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
        assertEquals(2,inv.length());
        assertEquals("HealthPotion",inv.getItemNameInPosition(0));
        assertEquals("Wooden Sword",inv.getItemNameInPosition(1));
    }

    @Test
    public void testThrowAwayOne() {
        inv.addItem(item1);
        assertEquals(1,inv.length());
        inv.throwAway(item1);
        assertEquals(0, inv.length());
    }

    @Test
    public void testThrowAwayMultiple() {
        inv.addItem(item1);
        inv.addItem(item2);
        assertEquals(2,inv.length());
        inv.throwAway(item1);
        inv.throwAway(item2);
        assertEquals(0, inv.length());
    }

    @Test
    public void testLengthNone() {
        assertEquals(0,inv.length());
    }

    @Test
    public void testLengthSome() {
        inv.addItem(item1);
        inv.addItem(item2);
        assertEquals(2,inv.length());
    }
}
