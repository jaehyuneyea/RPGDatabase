package persistence;

import model.items.Inventory;
import model.items.Item;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// test class modeled after https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonReaderTest extends JsonTest {
    public static final String HEALTH_POTION_DETAIL = "A bottle containing a magical potion. Heals the user for 10 HP.";
    public static final String IRON_SWORD_DETAIL = "A well-built sturdy sword composed of iron.";

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/wonderland.json");
        try {
            Inventory i = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass test
        }
    }

    @Test
    public void testReaderEmptyInventory() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyInventory.json");
        try {
            Inventory i = reader.read();
            assertEquals("My Inventory",i.getName());
            assertEquals(0,i.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralInventory() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralInventory.json");
        try {
            Inventory i = reader.read();
            assertEquals("My Inventory", i.getName());
            List<Item> items = i.getItems();
            assertEquals(2, items.size());
            checkItem("HealthPotion", HEALTH_POTION_DETAIL,false,i.getItems().get(0));
            checkItem("Iron Sword", IRON_SWORD_DETAIL,true,i.getItems().get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
