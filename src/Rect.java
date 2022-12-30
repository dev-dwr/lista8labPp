import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.Arrays;
import java.util.List;

public class Rect extends Shape {
    private int width;
    private int height;
    private MyPoint center;


    public Rect(int width, int height, MyPoint center) {
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
    MyPoint getPosition() {
        return center;
    }

    @Override
    void translate(MyPoint myPoint) {
        this.center = new MyPoint(center.getX() + myPoint.getX(), center.getY() + myPoint.getY());
    }

    @Override
    public void draw(Mat image, Scalar color) {
        org.opencv.core.Rect rect = new org.opencv.core.Rect(center.getX(), center.getY(), width, height);
        Imgproc.rectangle(image, rect, color);
    }

    @Override
    List<MyPoint> getBoundingBox() {
        MyPoint position = getPosition();
        MyPoint rightTop = new MyPoint(position.getX() + getWidth() / 2, position.getY() + height / 2);
        MyPoint rightBottom = new MyPoint(position.getX() + getWidth() / 2, position.getY() - height / 2);
        MyPoint leftBottom = new MyPoint(position.getX() - getWidth() / 2, position.getY() - height / 2);
        MyPoint leftTop = new MyPoint(position.getX() - getWidth() / 2, position.getY() + height / 2);
        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);
    }
}
