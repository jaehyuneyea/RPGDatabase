package tests.items;

import model.items.IronSword;
import model.items.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.items.IronSword.IS_ATTACK_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IronSwordTest {
    Weapon weapon;

    @BeforeEach
    public void setup() {
        weapon = new IronSword();
    }

    @Test
    public void testConstructor() {
        assertEquals(IS_ATTACK_VALUE, weapon.getAttackItem());
        assertEquals("A well-built sturdy sword composed of iron.", weapon.getDetail());
    }
}

