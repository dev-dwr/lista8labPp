import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.*;

public class ComplexItem extends Item implements Singleton{
    private static Item INSTANCE = null;

    private List<Item> children;

    public ComplexItem(List<Item> children) {
        this.children = children;
    }

    public static Item getInstance() {
        if (INSTANCE == null) {
            throw new AssertionError("Initialize first");
        }
        return Singleton.getInstance(INSTANCE);
    }

    public static Item init(List<Item> children) {
        INSTANCE = new ComplexItem(children);
        return INSTANCE;
    }

    public List<Item> getChildren() {
        return children;
    }

    @Override
    MyPoint getPosition() {
        return null;
    }

    @Override
    void translate(MyPoint myPoint) {
        List<Item> items = getChildren();
        for (Item item : items) {
            item.translate(myPoint);
        }
    }

    @Override
    public void draw(Mat image, Scalar color, boolean box) {
        children.forEach(el -> el.draw(image, color, false));
        if(box){
            List<MyPoint> boundingBox = getBoundingBox();
            Imgproc.rectangle(image, new org.opencv.core.Point(boundingBox.get(0).getX(), boundingBox.get(0).getY()),
                    new org.opencv.core.Point(boundingBox.get(1).getX(), boundingBox.get(1).getY()), color);
        }
    }

    @Override
    List<MyPoint> getBoundingBox() {
        //bottom-right
        int rightX = Integer.MIN_VALUE;
        int yRight = Integer.MAX_VALUE;
        //top-left
        int topX = Integer.MAX_VALUE;
        int topY = Integer.MIN_VALUE;

        for(Item i : children){
            List<MyPoint> boundingBox = i.getBoundingBox();
            for(MyPoint p : boundingBox){
                rightX = Math.max(rightX, p.getX());
                yRight = Math.min(yRight, p.getY());

                topX =  Math.min(topX, p.getX());
                topY =  Math.max(topY, p.getY());
            }
        }
        return Arrays.asList(new MyPoint(rightX, yRight), new MyPoint(topX, topY));
    }
}
