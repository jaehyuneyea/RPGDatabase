package tests;

import model.items.Equippable;
import model.items.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EquippableTest {

    Equippable testEquip;

    @BeforeEach
    public void setup() {
        testEquip = new Weapon("Test","a test weapon",10);
    }

    @Test
    public void testConstructor() {
        assertTrue(testEquip.isEquippable());
    }
}
