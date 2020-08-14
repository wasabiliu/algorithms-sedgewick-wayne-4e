import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.1.31
 * Write a program that takes as command-line arguments an integer N 
 * and a double value p (between 0 and 1), plots N equally spaced dots
 * of size .05 on the circumference of a circle, and then, with probability 
 * p for each pair of points, draws a gray line connecting them.
 */
public class Exercise31_RandomConnections {
    public static void drawConnections(int N, double p) {
        StdDraw.setCanvasSize(512, 512);
        StdDraw.setScale(-1.0, 1.0);
        StdDraw.setPenRadius(.15);

        double[][] points = new double[N][2];
        for (int i = 0; i < N; i++) {
            points[i][0] = Math.cos(2 * Math.PI * i / N);
            points[i][1] = Math.sin(2 * Math.PI * i / N);
        }

        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.GRAY);

        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < N; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 10;
        double p = 0.5;
        if (args.length > 1) {
            N = Integer.parseInt(args[0]);
            p = Double.parseDouble(args[1]);
        }
        drawConnections(N, p);
    }
}
