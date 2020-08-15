import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.2.2
 * Write a Interval1D client that takes an int value N as command-line 
 * argument, reads N intervals (each defined by a pair of double values)
 * from standard input, and prints all pairs that intersect.
 */
public class Exercise02_Interval1D {

    public static void interval1d(int N) {
        Interval1D[] a = new Interval1D[N];
        generateIntervals(a);

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i].intersects(a[j])) {
                    System.out.println(a[i].toString() + " " + a[j].toString());
                }
            }
        }
    }

    private static void generateIntervals(Interval1D[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            if (x > y) {
                double t = x;
                x = y;
                y = t;
            }
            intervals[i] = new Interval1D(x, y);
        }
    }

    public static void main(String[] args) {
        int N = 10;
        interval1d(N);
    }
}
