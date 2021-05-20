package events;

public class Event {
    private final int ID;
    private final Category CATEGORY;

    public Event(int id) {
        this.ID = id;
        this.CATEGORY = this.getCategoryFromID(id);
    }

    private Category getCategoryFromID(int id) {
        return CategoryDB.hashEventID(id);
    }

    public boolean hasID(int id) {
        return id == this.ID;
    }
}
