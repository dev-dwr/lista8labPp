import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.Arrays;
import java.util.List;

public class Segment extends Primitive implements Singleton {
    private static Item INSTANCE = null;
    private int length;
    private MyPoint start;
    private MyPoint end;

    public Segment(int length, MyPoint start, MyPoint end) {
        this.length = length;
        this.start = start;
        this.end = end;
    }

    public static Item getInstance() {
        if (INSTANCE == null) {
            throw new AssertionError("Initialize first");
        }
        return Singleton.getInstance(INSTANCE);
    }

    public static Item init(int length, MyPoint start, MyPoint end) {
        INSTANCE = new Segment(length, start, end);
        return INSTANCE;
    }

    public int getLength() {
        return length;
    }

    public MyPoint getStart() {
        return start;
    }

    public MyPoint getEnd() {
        return end;
    }

    @Override
    MyPoint getPosition() {
        return start;
    }

    @Override
    void translate(MyPoint myPoint) {
        this.start = new MyPoint(myPoint.getX() + start.getX(), myPoint.getY() + start.getY());
        this.end = new MyPoint(myPoint.getX() + start.getX(), myPoint.getY() + start.getY());
    }

    @Override
    public void draw(Mat image, Scalar color, boolean box) {
        Imgproc.line(image, new Point(start.getX(), start.getY()), new Point(end.getX(), end.getY()), color);
        if (box) {
            List<MyPoint> boundingBox = getBoundingBox();
            Imgproc.rectangle(image, new org.opencv.core.Point(boundingBox.get(0).getX(), boundingBox.get(0).getY()),
                    new org.opencv.core.Point(boundingBox.get(2).getX(), boundingBox.get(2).getY()), color);
        }
    }

    @Override
    List<MyPoint> getBoundingBox() {
        MyPoint leftBottom = this.start;
        MyPoint rightBottom = new MyPoint(end.getX(), start.getY());
        MyPoint rightTop = this.end;
        MyPoint leftTop = new MyPoint(start.getX(), end.getY());
        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);
    }
}
