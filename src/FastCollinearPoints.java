import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private final List<LineSegment> lineSegments;

    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();

        Point[] pointsBySlopeOrder = Arrays.copyOf(points, points.length);
        validateNoNullPoints(pointsBySlopeOrder);
        validatePointsNotDuplicated(pointsBySlopeOrder);

        lineSegments = new ArrayList<>();

        ArrayList<Point> pointsWithEqualSlope = new ArrayList<>();
        for (Point eachUnsortedPoint : points) {
            Arrays.sort(pointsBySlopeOrder, eachUnsortedPoint.slopeOrder());
            
            for (int i = 1; i < pointsBySlopeOrder.length; i++) {
                if (Double.compare(eachUnsortedPoint.slopeTo(pointsBySlopeOrder[i]),
                                   eachUnsortedPoint.slopeTo(pointsBySlopeOrder[i - 1])) == 0) {
                    pointsWithEqualSlope.add(pointsBySlopeOrder[i]);
                } else {
                    createCollinearSegmentIfNotKnown(pointsWithEqualSlope);
                    
                    pointsWithEqualSlope.clear();
                    pointsWithEqualSlope.add(eachUnsortedPoint); // p
                    pointsWithEqualSlope.add(pointsBySlopeOrder[i]);   // candidate
                }
            }
        }
    }

    private void validateNoNullPoints(Point[] sortedPoints) {
        if (sortedPoints.length == 1 && sortedPoints[0] == null) throw new IllegalArgumentException();
        else {
            try {
                Arrays.sort(sortedPoints);
            } catch (NullPointerException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
    private void validatePointsNotDuplicated(Point[] sortedPoints) {
        for (int i = 1; i < sortedPoints.length; i++) {
            if (sortedPoints[i-1].compareTo(sortedPoints[i]) == 0) throw new IllegalArgumentException("Duplicate point at " + sortedPoints[i].toString());
        }
    }

    private void createCollinearSegmentIfNotKnown(ArrayList<Point> pointsWithEqualsSlope) {
        if (pointsWithEqualsSlope.size() < 4) {
            return;
        }

        Point[] pointsWithEqualSlopeSortedByPosition = pointsWithEqualsSlope.toArray(new Point[pointsWithEqualsSlope.size()]);
        Arrays.sort(pointsWithEqualSlopeSortedByPosition);
        Point lowestPoint = pointsWithEqualSlopeSortedByPosition[0];
        Point highestPoint = pointsWithEqualSlopeSortedByPosition[pointsWithEqualSlopeSortedByPosition.length - 1];
        LineSegment candidateLineSegment = new LineSegment(lowestPoint, highestPoint);

        for (LineSegment knownLineSegment : lineSegments) {
            if (knownLineSegment.toString().equals(candidateLineSegment.toString())) return;
        }

        lineSegments.add(candidateLineSegment);
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }
}
