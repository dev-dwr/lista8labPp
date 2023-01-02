import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.Arrays;
import java.util.List;

public class Circle extends Shape {
    private int radius;
    private MyPoint center;
    private boolean activeBoudingBox;
    private int thickness = 2;
    public Circle(int radius, MyPoint center) {
        this.radius = radius;
        this.center = center;
        super.isFilled = thickness == -1 ? true : false;
    }

    public boolean isActiveBoudingBox() {
        return activeBoudingBox;
    }

    public void setActiveBoudingBox(boolean activeBoudingBox) {
        this.activeBoudingBox = activeBoudingBox;
    }

    public int getRadius() {
        return radius;
    }


    @Override
    boolean getFilled() {
        return isFilled;
    }

    @Override
    MyPoint getPosition() {
        return center;
    }

    @Override
    void translate(MyPoint myPoint) {
        this.center = new MyPoint(myPoint.getX() + center.getX(), myPoint.getY() + center.getY());
    }

    @Override
    public void draw(Mat image, Scalar color, boolean box) {
        Imgproc.circle(image, new Point(center.getX(), center.getY()), getRadius(), color, thickness);
        if (box) {
            List<MyPoint> boundingBox = getBoundingBox();
            Imgproc.rectangle(image, new Point(boundingBox.get(2).getX(), boundingBox.get(2).getY()),
                    new Point(boundingBox.get(0).getX(), boundingBox.get(0).getY()), color);
        }
    }

    @Override
    List<MyPoint> getBoundingBox() {
        MyPoint position = getPosition();
        MyPoint rightTop = new MyPoint(position.getX() + radius, position.getY() + radius);
        MyPoint rightBottom = new MyPoint(position.getX() + radius, position.getY() - radius);
        MyPoint leftBottom = new MyPoint(position.getX() - radius, position.getY() - radius);
        MyPoint leftTop = new MyPoint(position.getX() - radius, position.getY() + radius);
        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);
    }
}
