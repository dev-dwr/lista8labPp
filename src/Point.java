public class Point {
    private int X;
    private int Y;

    public Point(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "[x=" + X + ", y=" + Y + "]";
    }
}
