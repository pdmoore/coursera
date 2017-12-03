import edu.princeton.cs.algs4.Point2D;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class PointSETTest {

    /*
    public class PointSET {
   public              void draw()                         // draw all points to standard draw
   public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle (or on the boundary)
   public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty
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

    @Test
    public void contains_ValidateParameter() {
        PointSET s = new PointSET();
        Executable containsCalledWithNull = () -> {
            s.contains(null);
        };
        assertThrows(IllegalArgumentException.class, containsCalledWithNull, "contains does not accept null parameter");
    }

    @Test
    public void contains_PointHasNotBeenInserted() {
        PointSET s = new PointSET();
        Point2D p = new Point2D(0.0, 0.0);
        assertFalse(s.contains(p), "contains should return false for a point that hasn't been inserted");
    }

    @Test
    public void contains_PointHasBeenInserted() {
        PointSET s = new PointSET();
        Point2D p = new Point2D(0.5, 0.1);
        s.insert(p);
        assertTrue(s.contains(p), "contains should return true for a point that has been inserted");
    }


}
