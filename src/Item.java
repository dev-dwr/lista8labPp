import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class Item extends JPanel {
    Point position;
    ComplexItem children;
    Scene scene;

    abstract Point getPosition();

    abstract void translate(Point point);
    public abstract void draw(Graphics g);
    abstract List<Point> getBoundingBox();
}
