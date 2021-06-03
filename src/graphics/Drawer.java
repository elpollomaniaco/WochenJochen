package graphics;

import java.awt.*;

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


}

