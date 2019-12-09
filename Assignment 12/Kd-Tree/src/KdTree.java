import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {
    final private Set<Point2D> setPoints;

    public KdTree() {
        setPoints = new TreeSet<>();
    }

    public boolean isEmpty() {
        return setPoints.isEmpty();
    }

    public int size() {
        return setPoints.size();
    }

    public void insert(Point2D point) {
        if (point == null) {
            throw new IllegalArgumentException();
        }
        this.setPoints.add(point);
    }

    public boolean contains(Point2D point) {
        if (point == null) {
            throw new IllegalArgumentException();
        }
        return setPoints.contains(point);
    }

    public void draw() {
        setPoints.forEach(point -> point.draw());
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException();
        }
        return setPoints.stream().filter(point -> rect.contains(point)).collect(Collectors.toList());
    }

    public Point2D nearest(Point2D point) {
        if (point == null) {
            throw new IllegalArgumentException();
        }
        return setPoints.stream().min(point.distanceToOrder()).get();
    }

    public static void main(String[] args) {
        KdTree pointSET = new KdTree();

        pointSET.insert(new Point2D(0, 0));
        pointSET.insert(new Point2D(0.1, 0.4));
        pointSET.insert(new Point2D(0.6, 0.5));

        System.out.println(pointSET.size());
        System.out.println(pointSET.nearest(new Point2D(0.8, 0.6)));
        System.out.println(pointSET.range(new RectHV(0.4, 0.3, 0.8, 0.6)));

        pointSET.draw();
        new RectHV(0.4, 0.3, 0.8, 0.6).draw();
    }
 }
