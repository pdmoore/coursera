import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FastCollinearPointsTest {
    /*
    public class FastCollinearPoints {
   public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
   public           int numberOfSegments()        // the number of line segments
   public LineSegment[] segments()                // the line segments
     */

    // same tests as BruteCollinear, except add ones with > 4 points

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

    // validate ctor input
    // not null
    // no dupes
}
