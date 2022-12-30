import org.opencv.core.Core;
import org.opencv.core.Point;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //TODO: Invalid ComplexItem
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Scene scene = new Scene();
        Rect rect = new Rect(200, 100, new MyPoint(50, 50));
        Circle circle = new Circle(30, new MyPoint(50, 50));
        circle.translate(new MyPoint(100, 100));
        Segment segment = new Segment(30, new MyPoint(20, 40), new MyPoint(40, 70));
        segment.translate(new MyPoint(10, 50));
        Triangle triangle = new Triangle(new MyPoint(50, 50), new MyPoint(100, 100), new MyPoint(150, 50));
        TextItem text = new TextItem("dupa123", new MyPoint(10, 50));
        text.translate(new MyPoint(100, 100));
//        scene.addItem(rect);
//        scene.addItem(circle);
//        scene.addItem(segment);
//        scene.addItem(triangle);
//        scene.addItem(text);
//        Spiral spiral = new Spiral(new MyPoint(400, 300));
        //        spiral.translate(new MyPoint(50,50));
//        scene.addItem(spiral);
        List<Item> children = new ArrayList<>();
        children.add(rect);
        children.add(circle);
        children.add(text);
        ComplexItem complexItem = new ComplexItem(children);
        scene.addItem(complexItem);

        scene.draw();
    }
}
