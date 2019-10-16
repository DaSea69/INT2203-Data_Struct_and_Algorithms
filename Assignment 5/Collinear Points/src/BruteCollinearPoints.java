import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> lineSegments;
    private LineSegment[] arraySegments;

    public BruteCollinearPoints(Point[] points) {

        checkNullElement(points);
        checkDulicate(points);
        
        lineSegments = new ArrayList<LineSegment>();
        points = points.clone();

        Arrays.sort(points);

        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int m = k + 1; m < points.length; m++) {
                        if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) 
                        && points[i].slopeTo(points[j]) == points[i].slopeTo(points[m])) {
                            lineSegments.add(new LineSegment(points[i], points[m]));
                        }
                    }
                }
            }
        }
        arraySegments = new LineSegment[lineSegments.size()];
        arraySegments = lineSegments.toArray(arraySegments);
    }


    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return arraySegments.clone();
    }

    private void checkNullElement(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("List point is null");
        }
        for (Point point : points) {
            if (point == null) {
                throw new IllegalArgumentException("Null point");
            }
        }
    }

    private void checkDulicate(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Dulicate point");
                }
            }
        }
    }

    public static void main(String[] args) {

            In in = new In(args[0]);
            int n = in.readInt();
            Point[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                int x = in.readInt();
                int y = in.readInt();
                points[i] = new Point(x, y);
            }
        
            StdDraw.enableDoubleBuffering();
            StdDraw.setXscale(0, 32768);
            StdDraw.setYscale(0, 32768);
            for (Point p : points) {
                p.draw();
            }
            StdDraw.show();
        
            BruteCollinearPoints collinear = new BruteCollinearPoints(points);
            for (LineSegment segment : collinear.segments()) {
                StdOut.println(segment);
                segment.draw();
            }
            StdDraw.show();
    }
}