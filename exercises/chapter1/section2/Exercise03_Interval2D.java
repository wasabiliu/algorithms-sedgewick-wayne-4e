import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.2.3
 * Write an Interval2D client that takes command-line arguments N, min, and
 * max and generates N random 2D intervals whose width and height are uniformly
 * distributed between min and max in the unit square. Draw them on StdDraw and
 * print the number of pairs of intervals that intersect and the number of
 * intervals that are contained in one another.
 */
public class Exercise03_Interval2D {

    private static Map<Interval2D, Interval1D[]> maps = new HashMap<>();

    public static void plotInterval2D(int N, double min, double max) {
        Interval2D[] intervals = new Interval2D[N];
        generateInterval2Ds(intervals, min, max);

        StdDraw.setCanvasSize(512, 512);
        StdDraw.setPenRadius(.001);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        for (int i = 0; i < N; i++) {
            intervals[i].draw();
        }

        int intersect = 0, contain = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    intersect++;
                }
                if (isContained(intervals[i], intervals[j])) {
                    contain++;
                }
            }
        }

        System.out.println("# of intersect: " + intersect);
        System.out.println("# of contain: " + contain);
    }

    private static boolean isContained(Interval2D x, Interval2D y) {
        Interval1D[] xIntervals = maps.get(x);
        Interval1D[] yIntervals = maps.get(y);

        return (xIntervals[0].min() < yIntervals[0].min() &&
                xIntervals[0].max() > yIntervals[0].max() &&
                xIntervals[1].min() < yIntervals[1].min() &&
                xIntervals[1].max() > yIntervals[1].max()) ||
                (xIntervals[0].min() > yIntervals[0].min() &&
                        xIntervals[0].max() < yIntervals[0].max() &&
                        xIntervals[1].min() > yIntervals[1].min() &&
                        xIntervals[1].max() < yIntervals[1].max());
    }

    private static void generateInterval2Ds(Interval2D[] intervals, double min, double max) {
        for (int i = 0; i < intervals.length; i++) {
            Interval1D x = generateInterval1D(min, max);
            Interval1D y = generateInterval1D(min, max);
            intervals[i] = new Interval2D(x, y);
            maps.put(intervals[i], new Interval1D[]{x, y});
        }
    }

    private static Interval1D generateInterval1D(double min, double max) {
        double x = StdRandom.uniform(min, max);
        double y = StdRandom.uniform(min, max);
        if (x > y) {
            double t = x;
            x = y;
            y = t;
        }
        return new Interval1D(x, y);
    }

    public static void main(String[] args) {
        int N = 10;
        double min = 4.5, max = 9.0;
        plotInterval2D(N, min, max);
    }
}
