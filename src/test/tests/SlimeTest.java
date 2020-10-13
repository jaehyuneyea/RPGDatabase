package tests;

import model.interactables.Slime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlimeTest {

    Slime slimeTest;

    @BeforeEach
    public void setup() {
        slimeTest = new Slime("Slime",10,1,0);
    }

    @Test
    public void testConstructor() {
        assertEquals(1, slimeTest.getAttack());
        assertEquals(0, slimeTest.getDefense());
        assertEquals(10, slimeTest.getHP());
    }
}
