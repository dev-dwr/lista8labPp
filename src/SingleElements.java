import java.util.List;

public interface SingleElements {
    default void removeDuplicatedInGivenElement(List<Item> items) {
        Item item = null;
        int number = 0;

        for (Item item1 : items)
            if (item1 instanceof Triangle && number++ < 1){
                item = item1;
            }


        if (number > 1){
            items.remove(item);
        }
    }
}
