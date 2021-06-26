package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Panel extends JPanel {
    Graphics2D g2d;
    int x, y, dayCount, slotCount;
    int offsetX = 10;
    int offsetY = -25;
    BufferedImage[] imageSlots;
    BufferedImage emptyImage = null;

    public Panel(int x, int y, int dayCount, int slotCount) {
        this.x = x;
        this.y = y;
        this.dayCount = dayCount;
        this.slotCount = slotCount;
        imageSlots = new BufferedImage[dayCount * slotCount];
        setSize(x, y);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        refresh();
    }

    private void drawGrid() {
        if (g2d != null) {
            float baseX = (15f/ 141f) * x;
            float deltaX = (float)x / (dayCount + 1);  // rounded badly
            float deltaY = (float)y / (slotCount + 1);

            float curX = baseX + 0.5f * deltaX;
            float curY;

            BufferedImage img;
            g2d.setColor(Color.red);

            for (int i = 0; i < dayCount; i++) {
                curY = 1.5f * deltaY;
                for (int j = 0; j < slotCount; j++) {
                    img = this.imageSlots[i * slotCount + j];

                    if (img != null) {
                    g2d.drawImage(img, (int)curX + offsetX, (int)curY + offsetY, (int)deltaY, (int)deltaY, null);
                    g2d.drawRect((int) curX, (int)curY, 10, 10);
                    }
                    curY += deltaY;
                }
                curX += deltaX;
            }

            this.repaint();
            //g2d.drawLine(0,0,0,y);
            //g2d.drawLine(0,0,x,0);
            //g2d.drawLine(x,0,x,y);
            //g2d.drawLine(0,y,x,y);

        }
    }

    void refresh() {
        this.drawGrid();
    }

    void addImage(BufferedImage img, int day, int timeSlot) {
        this.imageSlots[day * slotCount + timeSlot] = img;
    }
    
    void addImage(BufferedImage img, int slotNumber) {
        this.imageSlots[slotNumber] = img;
    }

    void removeImage(int day, int timeSlot) {
        this.imageSlots[day * slotCount + timeSlot] = emptyImage;
    }
}
