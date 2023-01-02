import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;

import java.util.LinkedList;
import java.util.List;



public class Scene {
    private java.util.List<Item> itemList = new LinkedList<>();
    private Mat image;
    private Scalar color;
    public static final int ROWS = 600;
    public static final int COLS = 800;

    public Scene() {
        this.image = new Mat(ROWS, COLS, CvType.CV_8UC3, new Scalar(255, 255, 255));
        this.color = new Scalar(0, 0, 255);
    }

    public void draw() {
        List<Item> items = getItemList();
        items.forEach(item -> item.draw(image, color, true));
        HighGui.imshow("Image", image);
        HighGui.waitKey();
    }

    void addItem(Item item) {
        itemList.add(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
