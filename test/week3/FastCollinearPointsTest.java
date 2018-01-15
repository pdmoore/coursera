package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FastCollinearPointsTest {

    @Test
    void NoCollinearPoints() {
        Point[] p = new Point[] {new Point(0,0), new Point(5, 1), new Point(3,3), new Point(2,4) };
        FastCollinearPoints f = new FastCollinearPoints(p);
        Assertions.assertEquals(0, f.numberOfSegments() );
    }

    @Test
    void FourCollinearPoints() {
        Point[] p = new Point[] {new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4) };
        FastCollinearPoints f = new FastCollinearPoints(p);
        Assertions.assertEquals(1, f.numberOfSegments());
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
        FastCollinearPoints f = new FastCollinearPoints(p);

        LineSegment expectedLs_1 = new LineSegment(new Point(10000,0), new Point(0, 10000));
        LineSegment expectedLs_2 = new LineSegment(new Point(3000,4000), new Point(20000, 21000));
        LineSegment[] actual = f.segments();
        assertEquals(2, actual.length, "there are only 2 collinear segments");
        Assertions.assertEquals(expectedLs_1.toString(), actual[0].toString());
        Assertions.assertEquals(expectedLs_2.toString(), actual[1].toString());
    }

    @Test
    void CollinearPoints_MoreThanFourPoints() {
        Point[] p = new Point[] {           // input8.txt
                new Point(19000,10000),
                new Point(18000,10000),
                new Point(32000,10000),
                new Point(21000,10000),
                new Point(1234,5678),
                new Point(14000,10000),
        };
        FastCollinearPoints f = new FastCollinearPoints(p);

        LineSegment expectedLs_1 = new LineSegment(new Point(14000,10000), new Point(32000, 10000));
        LineSegment[] actual = f.segments();
        assertEquals(1, actual.length, "there is only one collinear segment");
        Assertions.assertEquals(expectedLs_1.toString(), actual[0].toString());
    }

    @Test
    void ValidateConstructor_NullParamNotAllowed() {
        Executable constructorWithNullParam = () -> new FastCollinearPoints(null);
        assertThrows(IllegalArgumentException.class, constructorWithNullParam, "ctor should throw exception when passed null");
    }

    @Test
    void ValidateConstructor_PointArrayCannotContainNull() {
        Point[] p = new Point[] { new Point(0,0), new Point(1, 1), null, new Point(5,5) };
        Executable constructorWithNullValueInPointsArray = () -> new FastCollinearPoints(p);
        assertThrows(IllegalArgumentException.class, constructorWithNullValueInPointsArray, "param list cannot contain a null value");
    }

    @Test
    void ValidateConstuctor_PointArrayContainsSingleNull() {
        Point[] p = new Point[] { null };
        Executable constructorWithNullValueInPointsArray = () -> new FastCollinearPoints(p);
        assertThrows(IllegalArgumentException.class, constructorWithNullValueInPointsArray, "param list cannot contain a null value");
    }

    @Test
    void ValidateConstructor_PointArrayContainsDuplicateValue() {
        Point[] p = new Point[] { new Point(0,0), new Point(1,1), new Point(2,2), new Point(0,0) };
        Executable constructorWithDuplicatedPointInPointsArray = () -> new FastCollinearPoints(p);
        assertThrows(IllegalArgumentException.class, constructorWithDuplicatedPointInPointsArray, "param list cannot contain duplicate point [0,0]");
    }
}
