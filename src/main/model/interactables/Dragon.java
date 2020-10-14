package model.interactables;

public class Dragon extends Monster {
    protected String detail;

    public Dragon() {
        super("Dragon", 500, 20);
        this.detail = "A mystic scaled-beast. It is advised not to fight this creature alone.";
    }

    // getters

    public String getDetail() {
        return detail;
    }
}
