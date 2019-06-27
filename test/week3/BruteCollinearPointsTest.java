package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BruteCollinearPointsTest {

    @Test
    void ValidateConstructor_NullParamNotAllowed() {
        Executable constructorWithNullParam = () -> new BruteCollinearPoints(null);
        assertThrows(IllegalArgumentException.class, constructorWithNullParam, "ctor should throw exception when passed null");
    }

    @Test
    void ValidateConstructor_PointArrayCannotContainNull() {
        Point[] p = new Point[] { new Point(0,0), new Point(1, 1), null, new Point(5,5) };
        Executable constructorWithNullValueInPointsArray = () -> new BruteCollinearPoints(p);
        assertThrows(IllegalArgumentException.class, constructorWithNullValueInPointsArray, "param list cannot contain a null value");
    }

    @Test
    void ValidateConstuctor_PointArrayContainsSingleNull() {
        Point[] p = new Point[] { null };
        Executable constructorWithNullValueInPointsArray = () -> new BruteCollinearPoints(p);
        assertThrows(IllegalArgumentException.class, constructorWithNullValueInPointsArray, "param list cannot contain a null value");
    }

    @Test
    void ValidateConstructor_PointArrayContainsDuplicateValue() {
        Point[] p = new Point[] { new Point(0,0), new Point(1,1), new Point(2,2), new Point(0,0) };
        Executable constructorWithDuplicatedPointInPointsArray = () -> new BruteCollinearPoints(p);
        assertThrows(IllegalArgumentException.class, constructorWithDuplicatedPointInPointsArray, "param list cannot contain duplicate point [0,0]");
    }

    @Test
    void NoCollinearPoints() {
        Point[] p = new Point[] {new Point(0,0), new Point(5, 1), new Point(3,3), new Point(2,4) };
        BruteCollinearPoints b = new BruteCollinearPoints(p);
        Assertions.assertEquals(0, b.numberOfSegments() );
    }

    @Test
    void FourCollinearPoints() {
        Point[] p = new Point[] {new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4) };
        BruteCollinearPoints b = new BruteCollinearPoints(p);
        Assertions.assertEquals(1, b.numberOfSegments());
    }

    @Test
    void FourCollinearPoints_ConfirmLineSegment() {
        Point[] p = new Point[] {new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4) };
        BruteCollinearPoints b = new BruteCollinearPoints(p);

        LineSegment expected = new LineSegment(new Point(1,1), new Point(4,4));
        LineSegment[] actual = b.segments();
        Assertions.assertEquals(expected.toString(), actual[0].toString(), "week3.LineSegment equals checks identity, toString is good enough here (1, 1) -> (4, 4)");
    }

    @Test
    void CollinearPoints_DoNotDoubleCountSegments() {
        Point[] p = new Point[] {           // input8.txt
                new Point(10000,0),
                new Point(0,10000),
                new Point(3000,7000),
                new Point(7000,3000),
                new Point(20000,21000),
                new Point(3000,4000),
                new Point(14000,15000),
                new Point(6000,7000)
        };
        BruteCollinearPoints b = new BruteCollinearPoints(p);

        LineSegment expectedLs_1 = new LineSegment(new Point(10000,0), new Point(0, 10000));
        LineSegment expectedLs_2 = new LineSegment(new Point(3000,4000), new Point(20000, 21000));
        LineSegment[] actual = b.segments();
        assertEquals(2, actual.length, "there are only 2 collinear segments");
        // assert LS 1
        // assert LS 2
    }

    @Test
    @Disabled
    void RunMain() {
        String args[] = new String[] { "data/collinear/input8.txt" };
        BruteCollinearPoints.main(args);
    }
}
