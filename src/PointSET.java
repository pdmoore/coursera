import edu.princeton.cs.algs4.Point2D;

public class PointSET {


    private int pointCount;

    public PointSET() {
        pointCount = 0;
    }

    public boolean isEmpty() {
        return pointCount == 0;
    }

    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException();

        pointCount++;
    }

    public int size() {
        return pointCount;
    }
}
