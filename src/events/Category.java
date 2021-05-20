package events;

public class Category {
    private final int ID;
    private final String LABEL;

    public Category(int id, String label) {
        this.ID = id;
        this.LABEL = label;
    }

    int getID() {
        return this.ID;
    }

    public String getLabel() {
      return this.LABEL;
    }
}
