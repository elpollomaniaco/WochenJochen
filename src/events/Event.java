package events;

import java.awt.image.BufferedImage;

public class Event {
    private final int ID;
    private final Category CATEGORY;

    public Event(int id) {
        this.ID = id;
        this.CATEGORY = this.getCategoryFromID(id);
    }

    public Event(int id, Category cat) {
        this.ID = id;
        this.CATEGORY = cat;
    }

    private Category getCategoryFromID(int id) {
        return CategoryDB.hashEventID(id);
    }

    public boolean hasID(int id) {
        return id == this.ID;
    }

    public String getName() {
        return (this.CATEGORY != null ? this.CATEGORY.getLabel() : "No Category assigned");
    }

    public BufferedImage getImage() {
        return this.CATEGORY.getImage();
    }

    public Category getCategory(){
        return this.CATEGORY;
    }
}
