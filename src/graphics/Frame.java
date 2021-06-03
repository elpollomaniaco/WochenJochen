package graphics;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame(Panel panel, String title, int x, int y) {
        initInterface(panel, title, x, y);
    }

    private void initInterface(Panel panel, String title, int x, int y) {
        add(panel);

        setTitle(title);
        setSize(x,y);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
