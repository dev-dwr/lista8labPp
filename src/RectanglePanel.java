

import java.awt.Graphics;
import javax.swing.JPanel;

public class RectanglePanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;
        int y = 10;
        int width = 100;
        int height = 50;
        g.drawRect(x, y, width, height);
    }
}
