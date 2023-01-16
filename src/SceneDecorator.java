import org.opencv.core.Scalar;

import java.util.List;
import java.util.stream.Collectors;
//scene decorator here
public class SceneDecorator implements SceneInterface{
    private SceneInterface decoratedScene;
    private Scene scene;

    public SceneDecorator(SceneInterface decoratedScene, Scene scene) {
        this.decoratedScene = decoratedScene;
        this.scene = scene;
    }

    @Override
    public void draw(boolean enableBox) {
        List<Item> allItemsList = scene.getItemList();
        List<Item> filteredItems = allItemsList.stream().filter(pred -> pred instanceof ComplexItem).collect(Collectors.toList());
        Scalar newColor = new Scalar(0,0,0);
        filteredItems.forEach(item -> item.draw(scene.getImage(), newColor, true));

        decoratedScene.draw(false);
    }

}
