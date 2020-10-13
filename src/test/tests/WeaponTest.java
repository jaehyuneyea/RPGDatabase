package tests;

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
        c = new MainCharacter("John",10 ,10,10);
    }

    @Test
    public void testConstructor() {
        assertEquals(20, weapon.getAttackItem());
        assertEquals("a small sword", weapon.getDetail());

        assertEquals("John",c.getName());
        assertEquals(10,c.getHP());
        assertEquals(10, c.getAttack());
        assertEquals(10, c.getDefense());
    }

    @Test
    public void testAddWeapon() {
        weapon.addWeapon();
        assertEquals(30,c.getAttack());
        assertEquals(10,c.getDefense());
        assertEquals(10,c.getHP());
    }

}