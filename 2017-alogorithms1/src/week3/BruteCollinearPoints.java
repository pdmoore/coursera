package week3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private final List<LineSegment> lineSegments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();

        Point[] sortedPoints = Arrays.copyOf(points, points.length);
        validateNoNullPoints(sortedPoints);
        validatePointsNotDuplicated(sortedPoints);

        lineSegments = new ArrayList<>();
        findLindSegments(sortedPoints);
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

    private void findLindSegments(Point[] sortedPoints) {
        for (int p = 0; p < sortedPoints.length - 3; p++) {
            for (int q = p + 1; q < sortedPoints.length - 2; q++) {
                for (int r = q + 1; r < sortedPoints.length - 1; r++) {
                    for (int s =  r + 1; s < sortedPoints.length; s++) {

                        double slopePQ = sortedPoints[p].slopeTo(sortedPoints[q]);
                        double slopePR = sortedPoints[p].slopeTo(sortedPoints[r]);
                        double slopePS = sortedPoints[p].slopeTo(sortedPoints[s]);
                        if (Double.compare(slopePQ, slopePR) == 0 && Double.compare(slopePQ, slopePS) == 0) {
                            LineSegment lineSegment = new LineSegment(sortedPoints[p], sortedPoints[s]);
                            lineSegments.add(lineSegment);
                        }
                    }
                }
            }
        }
    }

    private void validatePointsNotDuplicated(Point[] sortedPoints) {
        for (int i = 1; i < sortedPoints.length; i++) {
            if (sortedPoints[i-1].compareTo(sortedPoints[i]) == 0) throw new IllegalArgumentException("Duplicate point at " + sortedPoints[i].toString());
        }
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
