package persistence;

import model.items.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

// model designed after https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonTest {
    protected void checkItem(String name, String detail, Boolean canEquip, Item item) {
        assertEquals(name, item.getName());
        assertEquals(detail, item.getDetail());
    }
}
