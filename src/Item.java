import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.util.List;

public abstract class Item{
    MyPoint position;
    ComplexItem children;
    Scene scene;


    abstract MyPoint getPosition();

    abstract void translate(MyPoint myPoint);
    public abstract void draw(Mat image, Scalar color, boolean box);
    abstract List<MyPoint> getBoundingBox();
}
