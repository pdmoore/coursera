import java.util.Arrays;

public class BruteCollinearPoints {

    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();

        Point[] sortedPoints = Arrays.copyOf(points, points.length);
        try {
            Arrays.sort(sortedPoints);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        validatePointsNotDuplicated(sortedPoints);
    }

    private void validatePointsNotDuplicated(Point[] sortedPoints) {
        for (int i = 1; i < sortedPoints.length; i++) {
            if (sortedPoints[i-1].compareTo(sortedPoints[i]) == 0) throw new IllegalArgumentException("Duplicate point at " + sortedPoints[i].toString());
        }
    }

    public int numberOfSegments() {
        return 0;
    }
}
