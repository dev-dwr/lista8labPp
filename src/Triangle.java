import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Triangle extends Shape {
    private Point p1;
    private Point p2;
    private Point p3;


    public Triangle(Point p1, Point p2, Point p3) {
        assert !p1.equals(p2);
        assert !p2.equals(p3);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    @Override
    boolean getFilled() {
        return false;
    }

    @Override
    Point getPosition() {
        return new Point((p1.getX() + p2.getX() + p3.getX()) / 3, (p1.getY() + p2.getY() + p3.getY()) / 3);
    }

    @Override
    void translate(Point point) {
        this.p1 = new Point(point.getX() + p1.getX(), point.getY() + p1.getY());
        this.p2 = new Point(point.getX() + p2.getX(), point.getY() + p2.getY());
        this.p3 = new Point(point.getX() + p3.getX(), point.getY() + p3.getY());
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    List<Point> getBoundingBox() {
        Point leftBottom = p1;
        Point rightBottom = p2;
        Point rightTop = new Point(p2.getX(), p3.getY());
        Point leftTop = new Point(p1.getX(), p3.getY());
        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);
    }
}
