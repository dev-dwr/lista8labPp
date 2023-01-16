import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.Arrays;
import java.util.List;

public class TextItem extends Item implements Singleton {
    private static Item INSTANCE = null;
    private String text;
    private Point org;
    private int fontFace = Imgproc.FONT_HERSHEY_SIMPLEX;
    private double fontScale = 1.0;
    private int thickness = 1;

    public TextItem(String text, MyPoint org) {
        this.text = text;
        this.org = new Point(org.getX(), org.getY());
    }

    public TextItem(String text) {
        this.text = text;
    }


    public static Item getInstance() {
        if (INSTANCE == null) {
            throw new AssertionError("Initialize first");
        }
        return Singleton.getInstance(INSTANCE);
    }

    public static Item init(String text, MyPoint org) {
        INSTANCE = new TextItem(text, org);
        return INSTANCE;
    }

    @Override
    MyPoint getPosition() {
        return new MyPoint((int) org.x, (int) org.y);
    }

    @Override
    public void draw(Mat image, Scalar color, boolean box) {
        List<MyPoint> points = getBoundingBox();
        MyPoint topLeft = points.get(1);
        MyPoint bottomRight = points.get(0);
        Imgproc.putText(image, text, org, fontFace, fontScale, color, thickness);
        if (box) {
            Imgproc.rectangle(image, new Point(topLeft.getX(), topLeft.getY()),
                    new Point(bottomRight.getX(), bottomRight.getY()), color);
        }

    }

    @Override
    void translate(MyPoint point) {
        this.org = new Point(point.getX() + org.x, point.getY() + org.y);
    }

    @Override
    List<MyPoint> getBoundingBox() {
        Size textSize = Imgproc.getTextSize(text, fontFace, fontScale, thickness, null);
        int textWidth = (int) textSize.width;
        int textHeight = (int) textSize.height;
        int baseline = (int) textSize.height;

        MyPoint rightBottom = new MyPoint((int) org.x + textWidth, (int) org.y + baseline);
        MyPoint leftTop = new MyPoint((int) org.x, (int) org.y - textHeight);
        return Arrays.asList(rightBottom, leftTop);
    }

    public String getText() {
        return text;
    }
}
