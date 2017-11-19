import org.junit.jupiter.api.Test;

import java.util.Comparator;

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

    @Test
    public void SlopeTo_WithSamePoint_NegativeInfinity() {
        Point p = new Point(0, 0);
        assertEquals(Double.NEGATIVE_INFINITY, p.slopeTo(p));
    }

    @Test
    public void SlopeTo_HorizontalLine_PositiveInfinity() {
        Point p = new Point(1, 1);
        Point p_sameXcoord = new Point( 1, 5);
        assertEquals(Double.POSITIVE_INFINITY, p.slopeTo(p_sameXcoord));
    }

    @Test
    public void SlopeTo_PositiveSlope() {
        Point p = new Point(5,5);
        Point other = new Point(1,1);
        assertEquals(1.0, p.slopeTo(other));
    }

    @Test
    public void SlopeTo_NegativeSlope() {
        Point p = new Point(1,5);
        Point other = new Point(5, 1);
        assertEquals(-1.0, p.slopeTo(other));
    }

    @Test
    public void Comparator_HorizontalPoints() {
        Point p1 = new Point (0,0);
        Comparator<Point> c = p1.slopeOrder();
        Point p2 = new Point(5,0);
        Point p3 = new Point(3,0);
        assertTrue(c.compare(p2, p3) == 0, "slope p1-p2 is same as p1-p3, expect 0");
    }

    @Test
    public void Comparator_LessThan() {
        Point p1 = new Point(1,1);
        Comparator<Point> c = p1.slopeOrder();
        Point p2 = new Point(5,2);
        Point p3 = new Point(3,3);
        assertTrue(c.compare(p2, p3) < 0, "slope p1-p2 is less than slope p1-p3");
    }

    @Test
    public void Comparator_GreaterThan() {
        Point p1 = new Point(1,1);
        Comparator<Point> c = p1.slopeOrder();
        Point p2 = new Point(5,2);
        Point p3 = new Point(3,3);
        assertTrue(c.compare(p3, p2) > 0, "slope p1-p3 is greater than slope p1-p2");
    }
}
