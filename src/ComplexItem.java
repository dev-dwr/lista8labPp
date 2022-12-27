import java.awt.*;
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
    Point getPosition() {
        List<Item> items = getChildren();
        int widthSum = 0;
        int heightSum = 0;

        for (Item item : items) {
            widthSum += item.getPosition().getX();
            heightSum += item.getPosition().getY();
        }
        return new Point(widthSum / items.size(), heightSum / items.size());
    }

    @Override
    void translate(Point point) {
        List<Item> items = getChildren();
        for (Item item : items) {
            item.translate(point);
        }
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    List<Point> getBoundingBox() {
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

        Point rightTop = new Point(sumRightTopX / size, sumRightTopY / size);
        Point rightBottom = new Point(sumRightBottomX / size, sumRightBottomY / size);
        Point leftBottom = new Point(sumLeftBottomX / size, sumLeftBottomY / size);
        Point leftTop = new Point(sumLeftTopX / size, sumLeftTopY / size);

        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);
    }
}
