import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Circle extends Shape {
    private int radius;
    private Point center;

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle(int radius, Point center) {
        this.radius = radius;
        super.position = center;
    }

    public int getRadius() {
        return radius;
    }


    @Override
    boolean getFilled() {
        return false;
    }

    @Override
    Point getPosition() {
        return center;
    }

    @Override
    void translate(Point point) {
        this.center = new Point(point.getX() + center.getX(), point.getY() + center.getY());
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    List<Point> getBoundingBox() {
        Point position = getPosition();
        Point rightTop = new Point(position.getX() + radius, position.getY() + radius);
        Point rightBottom = new Point(position.getX() + radius, position.getY() - radius);
        Point leftBottom = new Point(position.getX() - radius, position.getY() - radius);
        Point leftTop = new Point(position.getX() - radius, position.getY() + radius);
        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);
    }
}
