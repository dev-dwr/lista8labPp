import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spiral extends Shape {

    private MyPoint center;
    private int thickness = 2;
    private int lineType = Imgproc.LINE_8;
    private int shift = 0;
    private Point[] vertices = new Point[10];

    public Spiral(MyPoint center) {
        this.center = center;
    }


    @Override
    MyPoint getPosition() {
        return center;
    }

    @Override
    void translate(MyPoint point) {
        center = new MyPoint(center.getX() + point.getX(), center.getY() + point.getY());
    }

    @Override
    public void draw(Mat image, Scalar color) {
        Point center = new Point(this.center.getX(), this.center.getY());
        int radius = 200;
        //vertices of the star polygon
        for (int i = 0; i < 10; i++) {
            double angle = Math.toRadians(36 * i);
            double x = center.x + radius * Math.cos(angle);
            double y = center.y + radius * Math.sin(angle);
            vertices[i] = new Point(x, y);
        }

        // draw
        for (int i = 0; i < 5; i++) {
            Imgproc.line(image, vertices[i], vertices[(i + 5) % 10], color, thickness, lineType, shift);
        }

        MatOfPoint2f polygon = new MatOfPoint2f(vertices);
        RotatedRect box = Imgproc.minAreaRect(polygon);
        Point[] boxVertices = new Point[4];
        box.points(boxVertices);

        //boduing box draw
        Imgproc.line(image, boxVertices[0], boxVertices[1], color, thickness, lineType, shift);
        Imgproc.line(image, boxVertices[1], boxVertices[2], color, thickness, lineType, shift);
        Imgproc.line(image, boxVertices[2], boxVertices[3], color, thickness, lineType, shift);
        Imgproc.line(image, boxVertices[3], boxVertices[0], color, thickness, lineType, shift);
    }

    @Override
    List<MyPoint> getBoundingBox() {
        MatOfPoint2f polygon = new MatOfPoint2f(vertices);
        RotatedRect box = Imgproc.minAreaRect(polygon);
        Point[] boxVertices = new Point[4];
        box.points(boxVertices);
        List<MyPoint> result = new ArrayList<>();
        for(Point p : boxVertices){
            result.add(new MyPoint((int)p.x, (int)p.y));
        }
        return result;
    }
}
