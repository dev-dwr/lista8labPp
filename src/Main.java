import org.opencv.core.Core;
import org.opencv.core.Point;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //TODO: Invalid ComplexItem
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Scene scene = new Scene();
        Rect rect = new Rect(100, 100, new MyPoint(100, 50));
        Circle circle = new Circle(30, new MyPoint(50, 50));
        circle.setActiveBoudingBox(false);
        circle.translate(new MyPoint(100, 100));
        Segment segment = new Segment(30, new MyPoint(20, 40), new MyPoint(40, 70));
        segment.translate(new MyPoint(10, 50));
        Triangle triangle = new Triangle(new MyPoint(50, 50), new MyPoint(100, 100), new MyPoint(150, 50));
        TextItem text = new TextItem("dupa123", new MyPoint(10, 50));
//        text.translate(new MyPoint(100, 100));
        scene.addItem(rect);
        scene.addItem(circle);
        scene.addItem(segment);
        scene.addItem(triangle);
//        scene.addItem(text);
        StarPolygon spiral = new StarPolygon(new MyPoint(400, 300));
                spiral.translate(new MyPoint(50,50));
        scene.addItem(spiral);

//        List<Item> children = new ArrayList<>();
//        Circle head = new Circle(50, new MyPoint(300, 100));
//        Circle middle = new Circle(100, new MyPoint(300, 250));
//        Circle bottom = new Circle(150, new MyPoint(300, 500));
//        TextItem text2 = new TextItem("elo", new MyPoint(10, 550));
//        children.add(head);
//        children.add(middle);
//        children.add(bottom);
//        children.add(text2);
//        ComplexItem complexItem = new ComplexItem(children);
//        scene.addItem(complexItem);

//        scene.addItem(head);
//        scene.addItem(middle);
//        scene.addItem(bottom);
//        scene.addItem(text2);

        scene.draw();
    }
}
