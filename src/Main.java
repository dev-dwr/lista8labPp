import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rect rect = new Rect(2, 2, new Point(1, 1));
        Circle circle = new Circle(3, new Point(2, 2));
        Triangle triangle = new Triangle(new Point(1, 1), new Point(0, 0), new Point(-3, -3));

        List<Item> children = new ArrayList<>();
        children.add(rect);
        children.add(circle);
        children.add(triangle);
        ComplexItem complexItem = new ComplexItem(children);

        JFrame frame = new JFrame("Swing");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Scene scene = new Scene(List.of(rect));
        RectanglePanel panel = new RectanglePanel();

        scene.getItemList().forEach(item -> {
            frame.getContentPane().add(item);
        });

        frame.setVisible(true);
    }
}