import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointTest {

    @Test
    public void CompareTo_Equality_WithSelf() {
        Point p = new Point(1, 2);
        assertEquals(0, p.compareTo(p), "compare with self, point should report equal (0)");
    }

    @Test
    public void CompareTo_Equality_WithOtherAtSameCoordinate() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        assertEquals(0, p1.compareTo(p2), "points at same coordinate are equal");
    }

    @Test
    public void CompareTo_LessThan_YvalueDiffers() {
        Point p_less    = new Point(5, 0);
        Point p_greater = new Point(5, 10);
        assertTrue(p_less.compareTo(p_greater) < 0, "point asking is less than, returns negative value");
    }
}
