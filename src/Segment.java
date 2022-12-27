import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Segment extends Primitive {
    private int length;
    private Point start;
    private Point end;
    private Point center;

    public Segment(int length, Point start, Point end) {
        this.length = length;
        this.start = start;
        this.end = end;
    }

    public Segment(int length, Point start, Point end, Point center) {
        this.length = length;
        this.start = start;
        this.end = end;
        super.position = center;
    }

    public int getLength() {
        return length;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    Point getPosition() {
        return super.position;
    }

    @Override
    void translate(Point point) {
        this.start = new Point(point.getX() + start.getX(), point.getY() + start.getY());
        this.end = new Point(point.getX() + start.getX(), point.getY() + start.getY());
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    List<Point> getBoundingBox() {
        Point leftBottom = this.start;
        Point rightBottom = new Point(end.getX(), start.getY());
        Point rightTop = this.end;
        Point leftTop = new Point(start.getX(), end.getY());
        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);
    }
}
