package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Panel extends JPanel {
    Graphics2D g2d;
    int maxX, maxY, dayCount, slotCount;
    int x00 = 250, x01 = 1200, x10 = 150, x11 = 1400, y0 = 80, y1 = 780;
    int imgOffsetX = -40;
    int imgOffsetY = -20;
    BufferedImage[] imageSlots;
    BufferedImage emptyImage = null;

    public Panel(int x, int y, int dayCount, int slotCount) {
        this.maxX = x;
        this.maxY = y;
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
            float baseX = x00;
            //float deltaX = (float)maxX / (dayCount + 1);  // rounded badly
            float deltaY = (float)((y1 - y0) / (slotCount));	// rounded badly
            
            float curY = y0;

            BufferedImage img;
            g2d.setColor(Color.red);

            for (int j = 0; j < slotCount; j++) {
        		float startX = x00 + (x10 - x00) / (slotCount);
        		float endX = x01 + (x11 - x01) / (slotCount);
        		float deltaX = (endX - startX) / (dayCount);
            	float curX = startX;	   
        		
            	for( int i = 0; i < dayCount; i++) {
                    img = this.imageSlots[i * slotCount + j];
                    g2d.drawRect((int) curX, (int)curY, 10, 10);
                    
                    if (img != null) {
                    g2d.drawImage(img, (int)curX + imgOffsetX, (int)curY + imgOffsetY, 40, 40, null);
                    }
                    curX += deltaX;
            	}
            	
            	curY += deltaY;
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
        System.out.println("PanelRemoveImage d:" + day + " slot:" + timeSlot);
    }
}
