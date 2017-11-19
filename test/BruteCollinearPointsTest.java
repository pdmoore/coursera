import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BruteCollinearPointsTest {


    /*
    public class BruteCollinearPoints {
   public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
   public           int numberOfSegments()        // the number of line segments
   public LineSegment[] segments()                // the line segments
}

     */

    @Test
    public void ValidateConstructor_NullParamNotAllowed() {
        Executable constructorWithNullParam = () -> {
            new BruteCollinearPoints(null);
        };
        assertThrows(IllegalArgumentException.class, constructorWithNullParam, "ctor should throw exception when passed null");
    }

    @Test
    public void ValidateConstructor_PointArrayCannotContainNull() {
        Point[] p = new Point[] { new Point(0,0), new Point(1, 1), null, new Point(5,5) };
        Executable constructorWithNullValueInPointsArray = () -> {
            new BruteCollinearPoints(p);
        };
        assertThrows(IllegalArgumentException.class, constructorWithNullValueInPointsArray, "param list cannot contain a null value");
    }

    @Test
    public void ValidateConstructor_PointArrayContainsDuplicateValue() {
        Point[] p = new Point[] { new Point(0,0), new Point(1,1), new Point(2,2), new Point(0,0) };
        Executable constructorWithDuplicatedPointInPointsArray = () -> {
            new BruteCollinearPoints(p);
        };
        assertThrows(IllegalArgumentException.class, constructorWithDuplicatedPointInPointsArray, "param list cannot contain duplicate point [0,0]");
    }
}
