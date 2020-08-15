import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.2.10
 * Develop a class VisualCounter that allows both increment and decrement operations.
 * Take two arguments N and max in the constructor, where N specifies the maximum number
 * of operations and max specifies the maximum absolute value for the counter. As a side
 * effect, create a plot showing the value of the counter each time its tally changes.
 */
public class Exercise10_VisualCounter {
    static class VisualCounter {
        private int N;          // maximum operations allowed
        private int max;        // max value for Math.abs(counter)
        private int operations; // current operations
        private int counter;    // current value for counter

        public VisualCounter(int N, int max) {
            if (N < 0 || max < 0)
                throw new IllegalArgumentException("N and max should be non-negative");
            this.N = N;
            this.max = max;
        }

        public void increment() {
            if (operations < N && counter < max) {
                operations++;
                counter++;
                plot();
            }
        }

        public void decrement() {
            if (operations < N && counter > -max) {
                operations++;
                counter--;
                plot();
            }
        }

        private void plot() {
            StdDraw.point(operations, counter);
        }
    }

    public static void main(String[] args) {
        int N = 10000, max = 20;
        VisualCounter vc = new VisualCounter(N, max);

        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(.0015);
        StdDraw.setXscale(0, N + 1);
        StdDraw.setYscale(-max * 3 / 2, max * 3 / 2);
        StdDraw.line(0, 0, N + 1, 0);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(0, -max, N + 1, -max);
        StdDraw.line(0, max, N + 1, max);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius(.005);

        for (int i = 0; i < N; i++) {
            if (StdRandom.bernoulli(0.5)) {
                vc.increment();
            } else {
                vc.decrement();
            }
        }
    }
}
