package events;

public final class CategoryDB {
    private static Category[] categories;

    public CategoryDB() {
        if (categories == null) {
            categories = new Category[]{
                    new Category(1, "Doctor"),
                    new Category(2, "Cinema"),
                    new Category(3, "School"),
            };
        }
    }

    static Category getCategory(int id) {
        for (Category cat : categories) {
            if (id == cat.getID()) {
                return cat;
            }
        }

        return null;
    }

    static Category hashEventID(int id) {
        int hashedID = id % categories.length;
        return getCategory(hashedID);
    }
}
