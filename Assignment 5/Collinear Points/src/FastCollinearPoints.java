import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    private ArrayList<LineSegment> lineSegments;
    private LineSegment[] arraySegments;

    public FastCollinearPoints(Point[] points) {
        checkNullElement(points);
        checkDulicate(points);

        lineSegments = new ArrayList<LineSegment>();
        points = points.clone();

        Arrays.sort(points);
        Point[] cloneOfPoits = points.clone();

        for(Point point : points) {
            Point originPoint = point;

            Arrays.sort(cloneOfPoits);
            Arrays.sort(cloneOfPoits, originPoint.slopeOrder());
            
            int left = 1;
            int right = left;
            while (left < cloneOfPoits.length - 2) {
                while (right < cloneOfPoits.length - 1 
                && originPoint.slopeTo(cloneOfPoits[left]) == originPoint.slopeTo(cloneOfPoits[right + 1])) {
                    right++;
                }
                if (right - left >= 2 && originPoint.compareTo(cloneOfPoits[left]) < 0) {
                    lineSegments.add(new LineSegment(originPoint, cloneOfPoits[right]));
                }
                left = ++right;
            }
        }
        arraySegments = new LineSegment[lineSegments.size()];
        arraySegments = lineSegments.toArray(arraySegments);

    }

    public int numberOfSegments() {
        return arraySegments.length;

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

        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}