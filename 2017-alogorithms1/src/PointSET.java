import edu.princeton.cs.algs4.Point2D;

import java.util.Set;
import java.util.TreeSet;

public class PointSET {

    private Set<Point2D> pointSet;

    public PointSET() {
        pointSet = new TreeSet();
    }

    public boolean isEmpty() {
        return pointSet.isEmpty();
    }

    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException();

        pointSet.add(p);
    }

    public int size() {
        return pointSet.size();
    }

    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException();

        return pointSet.contains(p);
    }

    public static void main(String[] args) {

    }
}
