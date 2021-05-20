package events;

public class Event {
    private final int id;
    private final Category category;

    public Event(int id) {
        this.id = id;
        this.category = this.getCategoryFromID(id);
    }

    private Category getCategoryFromID(int id) {
        return CategoryDB.hashEventID(id);
    }

    public boolean hasID(int id) {
        return id == this.id;
    }
}
