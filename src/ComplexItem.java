import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.util.Arrays;
import java.util.List;

public class ComplexItem extends Item {
    private List<Item> children;

    public ComplexItem(List<Item> children) {
        this.children = children;
    }

    public List<Item> getChildren() {
        return children;
    }

    @Override
    MyPoint getPosition() {
        List<Item> items = getChildren();
        int widthSum = 0;
        int heightSum = 0;

        for (Item item : items) {
            widthSum += item.getPosition().getX();
            heightSum += item.getPosition().getY();
        }
        return new MyPoint(widthSum / items.size(), heightSum / items.size());
    }

    @Override
    void translate(MyPoint myPoint) {
        List<Item> items = getChildren();
        for (Item item : items) {
            item.translate(myPoint);
        }
    }

    @Override
    public void draw(Mat image, Scalar color) {
        children.forEach(el -> el.draw(image, color));
    }

    @Override
    List<MyPoint> getBoundingBox() {
        List<Item> items = getChildren();
        int sumRightTopX = 0;
        int sumRightBottomX = 0;
        int sumLeftBottomX = 0;
        int sumLeftTopX = 0;

        int sumRightTopY = 0;
        int sumRightBottomY = 0;
        int sumLeftBottomY = 0;
        int sumLeftTopY = 0;


        for (Item item : items) {
            sumLeftBottomX = item.getBoundingBox().get(0).getX() + sumLeftBottomX;
            sumRightBottomX = item.getBoundingBox().get(1).getX() + sumRightBottomX;
            sumRightTopX = item.getBoundingBox().get(2).getX() + sumRightTopX;
            sumLeftTopX = item.getBoundingBox().get(3).getX() + sumLeftTopX;

            sumLeftBottomY = item.getBoundingBox().get(0).getX() + sumLeftBottomY;
            sumRightBottomY = item.getBoundingBox().get(1).getX() + sumRightBottomY;
            sumRightTopY = item.getBoundingBox().get(2).getX() + sumRightTopY;
            sumLeftTopY = item.getBoundingBox().get(3).getX() + sumLeftTopY;
        }
        int size = items.size();

        MyPoint rightTop = new MyPoint(sumRightTopX / size, sumRightTopY / size);
        MyPoint rightBottom = new MyPoint(sumRightBottomX / size, sumRightBottomY / size);
        MyPoint leftBottom = new MyPoint(sumLeftBottomX / size, sumLeftBottomY / size);
        MyPoint leftTop = new MyPoint(sumLeftTopX / size, sumLeftTopY / size);

        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);
    }
}
