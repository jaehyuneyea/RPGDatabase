package tests.persistence;

import model.items.HealthPotion;
import model.items.Inventory;
import model.items.Item;
import model.items.WoodenSword;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// test class modeled after https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonWriterTest extends JsonTest {
    public static final String HEALTH_POTION_DETAIL = "A bottle containing a magical potion. Heals the user for 10 HP.";
    public static final String WOODEN_SWORD_DETAIL = "A frail, weak wooden sword.";

    @Test
    public void testWriterInvalidFile() {
        try {
            Inventory i = new Inventory();
            JsonWriter writer = new JsonWriter("./data/my/filethatdoesntexist.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyInventory() {
        try {
            Inventory i = new Inventory();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyInventory.json");
            writer.open();
            writer.write(i);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyInventory.json");
            i = reader.read();
            assertEquals("My Inventory",i.getName());
            assertEquals(0,i.length());
        } catch (IOException e) {
            fail("Exception caught when it shouldn't have been thrown");
        }
    }

    @Test
    public void testWriterGeneralInventory() {
        WoodenSword ws = new WoodenSword();
        HealthPotion hp = new HealthPotion();
        try {
            Inventory i = new Inventory();
            i.addItem(hp);
            i.addItem(ws);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralInventory.json");
            writer.open();
            writer.write(i);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralInventory.json");
            i = reader.read();
            assertEquals("My Inventory",i.getName());
            List<Item> items = i.getItems();
            assertEquals(2, i.length());
            checkItem("HealthPotion",HEALTH_POTION_DETAIL,false,items.get(0));
            checkItem("Wooden Sword",WOODEN_SWORD_DETAIL,true,items.get(1));

        } catch (IOException e) {
            fail("Exception caught when it shouldn't have been thrown");
        }
    }
}
