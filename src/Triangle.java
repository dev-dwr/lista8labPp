import org.opencv.core.*;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import java.util.Arrays;
import java.util.List;

public class Triangle extends Shape {
    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;
    private int thickness = -1;


    public Triangle(MyPoint p1, MyPoint p2, MyPoint p3) {
        assert !p1.equals(p2);
        assert !p2.equals(p3);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        super.isFilled = thickness == -1 ? true : false;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public MyPoint getP1() {
        return p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public MyPoint getP3() {
        return p3;
    }

    @Override
    boolean getFilled() {
        return isFilled;
    }

    @Override
    MyPoint getPosition() {
        return new MyPoint((p1.getX() + p2.getX() + p3.getX()) / 3, (p1.getY() + p2.getY() + p3.getY()) / 3);
    }

    @Override
    void translate(MyPoint myPoint) {
        this.p1 = new MyPoint(myPoint.getX() + p1.getX(), myPoint.getY() + p1.getY());
        this.p2 = new MyPoint(myPoint.getX() + p2.getX(), myPoint.getY() + p2.getY());
        this.p3 = new MyPoint(myPoint.getX() + p3.getX(), myPoint.getY() + p3.getY());
    }

    @Override
    public void draw(Mat image, Scalar color, boolean box) {
        if(thickness == -1){
            Imgproc.fillConvexPoly(image,
                    new MatOfPoint(new Point(p1.getX(), p1.getY()),
                            new Point(p2.getX(),p2.getY()), new Point(p3.getX(),p3.getY())), color);
        }else {
            Imgproc.line(image, new Point(p1.getX(), p1.getY()), new Point(p2.getX(), p2.getY()), color, thickness);
            Imgproc.line(image, new Point(p2.getX(), p2.getY()), new Point(p3.getX(), p3.getY()), color, thickness);
            Imgproc.line(image, new Point(p3.getX(), p3.getY()), new Point(p1.getX(), p1.getY()), color, thickness);

            Mat triangle = new Mat(3, 1, CvType.CV_32FC2);
            triangle.put(0, 0, new double[]{(double) p1.getX(), (double) p1.getY()});
            triangle.put(1, 0, new double[]{(double) p2.getX(), (double) p2.getY()});
            triangle.put(2, 0, new double[]{(double) p3.getX(), (double) p3.getY()});


            if (box) {
                Rect boundingBox = Imgproc.boundingRect(triangle);
                int x = boundingBox.x;
                int y = boundingBox.y;
                int width = boundingBox.width;
                int height = boundingBox.height;
                Imgproc.rectangle(image, new Point(x, y), new Point(x + width, y + height), color);
            }

        }
    }

    @Override
    List<MyPoint> getBoundingBox() {
        MyPoint leftBottom = p1;
        MyPoint rightBottom = p2;
        MyPoint rightTop = new MyPoint(p2.getX(), p3.getY());
        MyPoint leftTop = new MyPoint(p1.getX(), p3.getY());

        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);

    }
}
