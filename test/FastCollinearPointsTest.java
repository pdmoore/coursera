import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FastCollinearPointsTest {

    @Test
    public void NoCollinearPoints() {
        Point[] p = new Point[] {new Point(0,0), new Point(5, 1), new Point(3,3), new Point(2,4) };
        FastCollinearPoints f = new FastCollinearPoints(p);
        assertEquals(0, f.numberOfSegments() );
    }

    @Test
    public void FourCollinearPoints() {
        Point[] p = new Point[] {new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4) };
        FastCollinearPoints f = new FastCollinearPoints(p);
        assertEquals(1, f.numberOfSegments());
    }

    @Test
    public void CollinearPoints_DoNotDoubleCountSegments() {
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
        assertEquals(expectedLs_1.toString(), actual[0].toString());
        assertEquals(expectedLs_2.toString(), actual[1].toString());
    }

    @Test
    public void CollinearPoints_MoreThanFourPoints() {
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
        assertEquals(expectedLs_1.toString(), actual[0].toString());
    }



    // validate ctor input
    // not null
    // no dupes
}
