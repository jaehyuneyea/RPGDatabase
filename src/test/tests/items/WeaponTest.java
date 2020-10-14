package tests.items;

import model.interactables.MainCharacter;
import model.items.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponTest {
    Weapon weapon;
    MainCharacter c;

    @BeforeEach
    public void setup() {
        weapon = new Weapon("Sword","a well-forged sword.",20);
        c = new MainCharacter("John",10 ,10);
    }

    @Test
    public void testConstructor() {
        assertEquals(20, weapon.getAttackItem());
        assertEquals("a well-forged sword.", weapon.getDetail());

        assertEquals("John",c.getName());
        assertEquals(10,c.getCurrentHP());
        assertEquals(10, c.getAttack());
    }

    @Test
    public void testAddWeapon() {
        weapon.addWeapon(c);
        assertEquals(30,c.getAttack());
        assertEquals(10,c.getCurrentHP());
    }

}