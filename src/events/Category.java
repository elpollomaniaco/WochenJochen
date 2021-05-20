package events;

public class Category {
    private final int id;
    private final String label;

    public Category(int id, String label) {
        this.id = id;
        this.label = label;
    }

    int getID() {
        return this.id;
    }

    public String getLabel() {
      return this.label;
    }
}
