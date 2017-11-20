import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private List<LineSegment> lineSegments;

    public FastCollinearPoints(Point[] points) {
        Point[] sortedPoints = Arrays.copyOf(points, points.length);
        Arrays.sort(sortedPoints);
        //check for dupes as in Brute
        
        lineSegments = new ArrayList<>();

        ArrayList<Point> pointsWithEqualSlope = new ArrayList<>();
        for (Point eachUnsortedPoint : points) {
            Arrays.sort(sortedPoints, eachUnsortedPoint.slopeOrder());
            
            for (int i = 1; i < sortedPoints.length; i++) {
                if (eachUnsortedPoint.slopeTo(sortedPoints[i]) == eachUnsortedPoint.slopeTo(sortedPoints[i - 1])) {
                    pointsWithEqualSlope.add(sortedPoints[i]);
                } else {
                    createCollinearSegmentIfExists(pointsWithEqualSlope);
                    
                    pointsWithEqualSlope.clear();
                    pointsWithEqualSlope.add(eachUnsortedPoint); // p
                    pointsWithEqualSlope.add(sortedPoints[i]);   // candidate
                }
            }
        }
    }

    private void createCollinearSegmentIfExists(ArrayList<Point> pointsWithEqualsSlope) {
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
}
