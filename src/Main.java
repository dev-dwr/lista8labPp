
import org.opencv.core.Core;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Scene scene = new Scene();
        Rect rect = new Rect(200, 100, new MyPoint(50, 50));
        Circle circle = new Circle(30, new MyPoint(50, 50));
        circle.translate(new MyPoint(100, 100));
        Segment segment = new Segment(30, new MyPoint(20, 40), new MyPoint(40, 70));
        //segment.translate(new MyPoint(10, 50));
        Triangle triangle = new Triangle(new MyPoint(50,50), new MyPoint(100,100), new MyPoint(150,50));
//        scene.addItem(rect);
//        scene.addItem(circle);
//        scene.addItem(segment);
        scene.addItem(triangle);
        scene.draw();

        List<Item> children = new ArrayList<>();
        children.add(rect);


    }
}
