package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PointTest {

    @Test
    void CompareTo_Equality_WithSelf() {
        Point p = new Point(1, 2);
        Assertions.assertEquals(0, p.compareTo(p), "compare with self, point should report equal (0)");
    }

    @Test
    void CompareTo_Equality_WithOtherAtSameCoordinate() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        Assertions.assertEquals(0, p1.compareTo(p2), "points at same coordinate are equal");
    }

    @Test
    void CompareTo_LessThan_YisLess() {
        Point p_y_is_less    = new Point(5, 0);
        Point p_x_same       = new Point(5, 10);
        Point p_x_less       = new Point(3, 10);
        Point p_x_greater    = new Point(7, 10);
        assertTrue(p_y_is_less.compareTo(p_x_same) < 0, "point asking is less than, returns negative value");
        assertTrue(p_y_is_less.compareTo(p_x_less) < 0, "point asking is less than, returns negative value");
        assertTrue(p_y_is_less.compareTo(p_x_greater) < 0, "point asking is less than, returns negative value");
    }

    @Test
    void CompareTo_GreaterThan_YisGreater() {
        Point p_y_is_greater = new Point(3, 9);
        Point p_x_same       = new Point(3, 0);
        Point p_x_less       = new Point(0, 0);
        Point p_x_greater    = new Point(5, 0);
        assertTrue(p_y_is_greater.compareTo(p_x_same) > 0, "point asking is greater than returns positive value");
        assertTrue(p_y_is_greater.compareTo(p_x_less) > 0, "point asking is greater than returns positive value");
        assertTrue(p_y_is_greater.compareTo(p_x_greater) > 0, "point asking is greater than returns positive value");
    }

    @Test
    void CompareTo_LessThan_YisSame_CheckX() {
        Point p_less    = new Point(3, 0);
        Point p_greater = new Point(4, 0);
        assertTrue(p_less.compareTo(p_greater) < 0, "when y value is same, check x");
    }

    @Test
    void CompareTo_GreaterThan_YisSame_CheckX() {
        Point p_greater = new Point(5, 8);
        Point p_less    = new Point(3, 8);
        assertTrue(p_greater.compareTo(p_less) > 0, "when y value is same, check x");
    }

    @Test
    void SlopeTo_WithSamePoint_NegativeInfinity() {
        Point p = new Point(0, 0);
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, p.slopeTo(p));
    }

    @Test
    void SlopeTo_HorizontalLine_PositiveInfinity() {
        Point p = new Point(1, 1);
        Point p_sameXcoord = new Point( 1, 5);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, p.slopeTo(p_sameXcoord));
    }

    @Test
    void SlopeTo_PositiveSlope() {
        Point p = new Point(5,5);
        Point other = new Point(1,1);
        Assertions.assertEquals(1.0, p.slopeTo(other));
    }

    @Test
    void SlopeTo_NegativeSlope() {
        Point p = new Point(1,5);
        Point other = new Point(5, 1);
        Assertions.assertEquals(-1.0, p.slopeTo(other));
    }

    @Test
    void Comparator_HorizontalPoints() {
        Point p1 = new Point(0,0);
        Comparator<Point> c = p1.slopeOrder();
        Point p2 = new Point(5,0);
        Point p3 = new Point(3,0);
        assertTrue(c.compare(p2, p3) == 0, "slope p1-p2 is same as p1-p3, expect 0");
    }

    @Test
    void Comparator_LessThan() {
        Point p1 = new Point(1,1);
        Comparator<Point> c = p1.slopeOrder();
        Point p2 = new Point(5,2);
        Point p3 = new Point(3,3);
        assertTrue(c.compare(p2, p3) < 0, "slope p1-p2 is less than slope p1-p3");
    }

    @Test
    void Comparator_GreaterThan() {
        Point p1 = new Point(1,1);
        Comparator<Point> c = p1.slopeOrder();
        Point p2 = new Point(5,2);
        Point p3 = new Point(3,3);
        assertTrue(c.compare(p3, p2) > 0, "slope p1-p3 is greater than slope p1-p2");
    }

    @Test
    void Comparator_HorizontalLine() {
        Point p = new Point(5,2);
        Point q = new Point(2,2);
        Point r = new Point(7,2);

        Comparator<Point> c = p.slopeOrder();
        assertEquals(0, c.compare(q, r));
    }

    @Test
    void SlopeTo_UnequalSlopes() {
        Point p = new Point(10,0);
        Point r = new Point(3,7);
        Point s = new Point(6,7);
        double slope_pr = p.slopeTo(r);
        double slope_ps = p.slopeTo(s);
        assertNotEquals(slope_pr, slope_ps, "these are obviously not the same slope!");
    }

    @Test
    void SlopeTo_Test1_HorizontalLine() {
        Point p = new Point(203,467);
        Point q = new Point(144,467);
        Assertions.assertEquals(0.0, p.slopeTo(q), "slope of horizontal line should be positive zero");
    }
}
