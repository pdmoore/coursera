import edu.princeton.cs.algs4.Point2D;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class PointSETTest {

    /*
    public class PointSET {
   public         PointSET()                               // construct an empty set of points
   public           boolean isEmpty()                      // is the set empty?
   public               int size()                         // number of points in the set
   public              void insert(Point2D p)              // add the point to the set (if it is not already in the set)
   public           boolean contains(Point2D p)            // does the set contain point p?
   public              void draw()                         // draw all points to standard draw
   public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle (or on the boundary)
   public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty

   public static void main(String[] args)                  // unit testing of the methods (optional)

     */

    @Test
    public void isEmpty_WhenNewlyConstructed() {
        PointSET s = new PointSET();
        assertTrue(s.isEmpty(), "newly constructed object doesn't contain any points");
    }

    @Test
    public void addOnePoint_CheckSizeAndEmptiness() {
        PointSET s = new PointSET();
        Point2D p = new Point2D(0.0, 0.0);
        s.insert(p);

        assertFalse(s.isEmpty(), "after adding a point the set is no longer empty");
        assertEquals(1, s.size(), "PointSET knows how many points have been inserted");
    }

    @Test
    public void insert_ValidateParameter() {
        PointSET s = new PointSET();
        Executable insertCalledWithNull = () -> {
            s.insert(null);
        };
        assertThrows(IllegalArgumentException.class, insertCalledWithNull, "insert does not accept null parameter");
    }
}
