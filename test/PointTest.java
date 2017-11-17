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
    public void CompareTo_LessThan_YisLess() {
        Point p_y_is_less    = new Point(5, 0);
        Point p_x_same       = new Point(5, 10);
        Point p_x_less       = new Point(3, 10);
        Point p_x_greater    = new Point(7, 10);
        assertTrue(p_y_is_less.compareTo(p_x_same) < 0, "point asking is less than, returns negative value");
        assertTrue(p_y_is_less.compareTo(p_x_less) < 0, "point asking is less than, returns negative value");
        assertTrue(p_y_is_less.compareTo(p_x_greater) < 0, "point asking is less than, returns negative value");
    }

    @Test
    public void CompareTo_GreaterThan_YisGreater() {
        Point p_y_is_greater = new Point(3, 9);
        Point p_x_same       = new Point(3, 0);
        Point p_x_less       = new Point(0, 0);
        Point p_x_greater    = new Point(5, 0);
        assertTrue(p_y_is_greater.compareTo(p_x_same) > 0, "point asking is greater than returns positive value");
        assertTrue(p_y_is_greater.compareTo(p_x_less) > 0, "point asking is greater than returns positive value");
        assertTrue(p_y_is_greater.compareTo(p_x_greater) > 0, "point asking is greater than returns positive value");
    }

    @Test
    public void CompareTo_LessThan_YisSame_CheckX() {
        Point p_less    = new Point(3, 0);
        Point p_greater = new Point(4, 0);
        assertTrue(p_less.compareTo(p_greater) < 0, "when y value is same, check x");
    }

    @Test
    public void CompareTo_GreaterThan_YisSame_CheckX() {
        Point p_greater = new Point(5, 8);
        Point p_less    = new Point(3, 8);
        assertTrue(p_greater.compareTo(p_less) > 0, "when y value is same, check x");

    }
}
