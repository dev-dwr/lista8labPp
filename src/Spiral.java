//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Spiral extends Shape {
//
//    private Point center;
//    private int turns;
//
//    public Spiral(Point center, int turns) {
//        this.center = center;
//        this.turns = turns;
//    }
//
//    public List<Point> getPoints() {
//        List<Point> points = new ArrayList<>();
//        double angle = 0;
//        double step = 0.1;
//        double r = 0;
//
//        for (int i = 0; i < turns * 100; i++) {
//            r = r + step;
//            angle = angle + step / r;
//
//            int x = (int) (center.getX() + r * Math.cos(angle));
//            int y = (int) (center.getY() + r * Math.sin(angle));
//
//            points.add(new Point(x, y));
//        }
//
//        return points;
//    }
//
//    @Override
//    Point getPosition() {
//        return center;
//    }
//
//    @Override
//    void translate(Point point) {
//        center = new Point(center.getX() + point.getX(), center.getY() + point.getY());
//    }
//
//    @Override
//    void draw() {
//
//    }
//
//    @Override
//    List<Point> getBoundingBox() {
//        List<Point> points = getPoints();
//
//        int minX = Integer.MAX_VALUE;
//        int minY = Integer.MAX_VALUE;
//        int maxX = Integer.MIN_VALUE;
//        int maxY = Integer.MIN_VALUE;
//
//        for (Point p : points) {
//            minX = Math.min(minX, p.getX());
//            minY = Math.min(minY, p.getY());
//            maxX = Math.max(maxX, p.getX());
//            maxY = Math.max(maxY, p.getY());
//        }
//        return new Rect(maxX - minX, maxY - minY, new Point(minX, minY)).getBoundingBox();
//    }
//}
