import edu.princeton.cs.algs4.Point2D;

import java.util.Set;
import java.util.TreeSet;

public class PointSET {


    private int pointCount;
    private Set<Point2D> pointSet;

    public PointSET() {
        pointCount = 0;
        pointSet = new TreeSet();
    }

    public boolean isEmpty() {
        return pointCount == 0;
    }

    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException();

        pointCount++;
        pointSet.add(p);
    }

    public int size() {
        return pointCount;
    }

    public static void main(String[] args) {

    }

    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException();

        return pointSet.contains(p);
    }
}
