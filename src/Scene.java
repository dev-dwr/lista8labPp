import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Scene{
    private java.util.List<Item> itemList;
    private JFrame frame;

    public Scene(List<Item> itemList) {
        this.itemList = itemList;
    }



    void addItem(Item item) {
        itemList.add(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
