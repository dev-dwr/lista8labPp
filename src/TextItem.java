//import java.awt.*;
//import java.util.Arrays;
//import java.util.List;
//
//public class TextItem extends Item {
//    private String text;
//    private Point center;
//
//    public TextItem(String text, Point center) {
//        this.text = text;
//        this.center = center;
//    }
//
//    @Override
//    Point getPosition() {
//        return center;
//    }
//
//    @Override
//    void translate(Point point) {
//        center = new Point(point.getX() + center.getX(), point.getY() + center.getY());
//    }
//
//    @Override
//    void draw() {
//
//    }
//
//    @Override
//    List<Point> getBoundingBox() {
//        Point rightTop = new Point(center.getX() + text.length() / 2, center.getY() + text.length() / 2);
//        Point rightBottom = new Point(center.getX() + text.length() / 2, center.getY() - text.length() / 2);
//        Point leftBottom = new Point(center.getX() - text.length() / 2, center.getY() -  text.length() / 2);
//        Point leftTop = new Point(center.getX() -  text.length() / 2, center.getY() +  text.length() / 2);
//        return Arrays.asList(leftBottom, rightBottom, rightTop, leftTop);
//    }
//
//    public TextItem(String text) {
//        this.text = text;
//    }
//
//    public String getText() {
//        return text;
//    }
//}
