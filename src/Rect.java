import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Rect extends Shape {
    private int width;
    private int height;
    private Point center;


    public Rect(int width, int height, Point center) {
        this.width = width;
        this.height = height;
        this.center = center;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
        this.center = new Point(center.getX() + point.getX(), center.getY() + point.getY());
    }


    @Override
    public void draw(Graphics g) {
        paintComponent(g);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;
        int y = 10;
        int width = 100;
        int height = 50;
        g.drawRect(x, y, width, height);
    }

    @Override
    List<Point> getBoundingBox() {
        Point position = getPosition();
        Point rightTop = new Point(position.getX() + getWidth() / 2, position.getY() + height / 2);
        Point rightBottom = new Point(position.getX() + getWidth() / 2, position.getY() - height / 2);
        Point leftBottom = new Point(position.getX() - getWidth() / 2, position.getY() - height / 2);
        Point leftTop = new Point(position.getX() - getWidth() / 2, position.getY() + height / 2);
        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);
    }
}
