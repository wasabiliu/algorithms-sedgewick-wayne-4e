import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.2.18
 * Validate that the following code, which adds the methods var() and stddev()
 * to Accumulator, computes both the mean and variance of the numbers presented
 * as arguments to adDataValue().
 */
public class Exercise18_VarianceAccumulator {
    static class Accumulator {
        private double m;
        private double s;
        private int N;

        public void addDataValue(double x) {
            N++;
            s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean() {
            return m;
        }

        public double var() {
            return s / (N - 1);
        }

        public double stddev() {
            return Math.sqrt(this.var());
        }
    }

    public static void main(String[] args) {
        int N = 10;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }

        Accumulator acc = new Accumulator();
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            acc.addDataValue(a[i]);
        }
        double expectedMean = sum / N;

        double expectedVar = 0;
        for (int i = 0; i < N; i++) {
            expectedVar += (a[i] - expectedMean) * (a[i] - expectedMean);
        }
        expectedVar /= (N - 1);
        double expectedStddev = Math.sqrt(expectedVar);

        System.out.println("mean: " + acc.mean() + ", expected mean: " + expectedMean);
        System.out.println("var: " + acc.var() + ", expected var: " + expectedVar);
        System.out.println("stddev: " + acc.stddev() + ", stddev mean: " + expectedStddev);
    }
}
