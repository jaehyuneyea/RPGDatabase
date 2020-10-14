package tests.interactables;

import model.interactables.Dragon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragonTest {

    Dragon d;

    @BeforeEach
    public void setup() {
        d = new Dragon();
    }

    @Test
    public void testConstructor() {
        assertEquals(20, d.getAttack());
        assertEquals(500, d.getCurrentHP());
        assertEquals("A mystic scaled-beast. It is advised not to fight this creature alone.", d.getDetail());
        assertEquals("Dragon", d.getName());
    }
}