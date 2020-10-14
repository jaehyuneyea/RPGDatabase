package tests.items;

import model.items.Weapon;
import model.items.WoodenSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.items.WoodenSword.WS_ATTACK_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WoodenSwordTest {
    Weapon weapon;

    @BeforeEach
    public void setup() {
        weapon = new WoodenSword();
    }

    @Test
    public void testConstructor() {
        assertEquals(WS_ATTACK_VALUE, weapon.getAttackItem());
        assertEquals("A frail, weak wooden sword.",weapon.getDetail());
    }
}
