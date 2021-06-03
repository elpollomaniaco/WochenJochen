package graphics;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    Graphics2D g2d;
    int x, y, dayCount, slotCount;

    public Panel(int x, int y, int dayCount, int slotCount) {
        this.x = x;
        this.y = y;
        this.dayCount = dayCount;
        this.slotCount = slotCount;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        drawGrid();
    }

    private void drawGrid() {
        if (g2d != null) {
            float baseX = (15f/ 141f) * x;
            float deltaX = (float)x / (dayCount + 1);  // rounded badly
            float deltaY = (float)y / (slotCount + 1);

            float curX = baseX;
            float curY = 0;
            for (int i = 0; i < dayCount; i++) {
                g2d.drawLine((int)curX, 0, (int)curX, y);
                curX = curX + deltaX;
            }

            for (int j = 0; j < slotCount; j++) {
                curY = curY + deltaY;
                g2d.drawLine(0, (int)curY, x, (int)curY);
            }

            g2d.drawLine(0,0,0,y);
            g2d.drawLine(0,0,x,0);
            g2d.drawLine(x,0,x,y);
            g2d.drawLine(0,y,x,y);

        }
    }

    void refresh() {
        if (g2d != null)
            g2d.drawString("Test", 50, 50);
    }
}
