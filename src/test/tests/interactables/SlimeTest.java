package tests.interactables;

import model.interactables.Slime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlimeTest {

    Slime slimeTest;

    @BeforeEach
    public void setup() {
        slimeTest = new Slime();
    }

    @Test
    public void testConstructor() {
        assertEquals(1, slimeTest.getAttack());
        assertEquals(10, slimeTest.getCurrentHP());
        assertEquals("A squishy, green slime. Hostile but really harmless.", slimeTest.getDetail());
        assertEquals("Slime",slimeTest.getName());
    }
}
