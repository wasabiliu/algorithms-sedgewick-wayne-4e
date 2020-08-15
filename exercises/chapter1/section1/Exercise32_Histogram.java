import edu.princeton.cs.algs4.StdDraw;

/**
 * 1.1.32
 * Suppose that the standard input stream is a sequence of double values.
 * Write a program that takes an integer N and two double values l and r from
 * the command line and uses StdDraw to plot a histogram of the count of the
 * numbers in the standard input stream that fall in each of the N intervals
 * defined by dividing (l, r) into N equal-sized intervals.
 */
public class Exercise32_Histogram {

    public static void plotHistogram(int N, double l, double r, double[] numbers) {
        double[] intervals = new double[N];
        generateIntervals(N, l, r, intervals);
        int[] counts = new int[N - 1];
        countNumbers(intervals, counts, numbers);

        StdDraw.setCanvasSize(512, 512);
        StdDraw.setPenRadius(.15);
        StdDraw.setXscale(0, N - 1);
        StdDraw.setPenColor(StdDraw.GRAY);

        int sum = 0;
        for (int i = 0; i < counts.length; i++) {
            sum += counts[i];
        }
        StdDraw.setYscale(0, sum);

        for (int i = 0; i < counts.length; i++) {
            double x = 1 * i + 0.5;
            double y = counts[i];
            double rw = 0.25;
            double rh = counts[i];
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    private static void generateIntervals(int N, double l, double r, double[] intervals) {
        double step = (r - l) / N;
        for (int i = 0; i < N; i++) {
            intervals[i] = l + step * i;
        }
    }

    private static void countNumbers(double[] intervals, int[] counts, double[] numbers) {
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] >= intervals[i] && numbers[j] < intervals[i + 1])
                    counts[i]++;
            }
        }
    }

    public static void main(String[] args) {
        int N = 10;
        double l = 4.5, r = 8.9;
        if (args.length > 2) {
            N = Integer.parseInt(args[0]);
            l = Double.parseDouble(args[1]);
            r = Double.parseDouble(args[2]);
        }
        double[] numbers = new double[]{
                4.55, 4.58, 4.91, 4.99, 5.01, 5.23, 6.27, 6.66, 7.09, 7.39, 7.77, 8.01, 8.04, 8.44, 9.01, 9.89
        };

        plotHistogram(N, l, r, numbers);
    }
}
