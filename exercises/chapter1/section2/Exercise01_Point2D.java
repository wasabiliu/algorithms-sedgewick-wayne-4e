import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.2.1
 * Write a Point2D client that takes an integer value N from the command line, 
 * generates N random points in the unit square, and computes the distance 
 * separating the closest pair of points.
 */
public class Exercise01_Point2D {

    public static void plotPoints(int N) {
        double[][] points = new double[N][2];
        generatePoints(points);

        StdDraw.setCanvasSize(512, 512);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(.01);

        for (int i = 0; i < N; i++) {
            StdDraw.point(points[i][0], points[i][1]);
        }

        double minDistance = computeDistance(points[0][0], points[0][1], points[1][0], points[1][1]);
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = computeDistance(
                        points[i][0], points[i][1],
                        points[j][0], points[j][1]
                );
                if (distance < minDistance) minDistance = distance;
                System.out.println(distance);
            }
        }

        System.out.println("THe minimum distance is: " + minDistance);
    }

    private static double computeDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private static void generatePoints(double[][] points) {
        for (int i = 0; i < points.length; i++) {
            points[i][0] = StdRandom.uniform(0.0, 1.0);
            points[i][1] = StdRandom.uniform(0.0, 1.0);
        }
    }

    public static void main(String[] args) {
        plotPoints(10);
    }
}
