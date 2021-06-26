package graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawer {
    private Panel panel;

    public Drawer(String title, int x, int y, int dayCount, int slotCount) {
        panel = new Panel(x, y, dayCount, slotCount);

        EventQueue.invokeLater(() -> {
            Frame frame = new Frame(panel, title, x, y);
            frame.setVisible(true);
        });

        refreshDrawing();
    }


    public void refreshDrawing() {
        panel.refresh();
    }

    public void addImage(BufferedImage img, int day, int timeSlot) {
        this.panel.addImage(img, day, timeSlot);
    }
    
    public void addImage(BufferedImage img, int slotNumber) {
    	this.panel.addImage(img, slotNumber);
    }


}

