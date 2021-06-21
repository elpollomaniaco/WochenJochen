package events;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Category {
    private final int ID;
    private final String LABEL;
    private final BufferedImage IMG;

    public Category(int id, String label, String imgUrl) {
        this.ID = id;
        this.LABEL = label;

        BufferedImage img = null;

        try {
            img = ImageIO.read(getClass().getResource(imgUrl));
        } catch (IOException e) {
            System.err.println("Couldn't load image " + imgUrl);
        }

        this.IMG = img;
    }

    int getID() {
        return this.ID;
    }

    String getLabel() {
      return this.LABEL;
    }

    public BufferedImage getImage() {
        return IMG;
    }
}
