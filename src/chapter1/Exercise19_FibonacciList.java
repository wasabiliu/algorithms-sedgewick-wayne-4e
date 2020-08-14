import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.19
 * Run the following program on your computer
 * Develop a better implementation of F(N) that saves computed values
 * in an array.
 */
public class Exercise19_FibonacciList {
    // very slow
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    // a better one
    public static long[] betterF(int N) {
        if (N < 0) return null;
        long[] result = new long[N];
        if (N < 1) return result;
        if (N < 2) {
            result[0] = 0;
            return result;
        }
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < N; i++) result[i] = result[i - 1] + result[i - 2];
        return result;
    }

    private static void printLongArray(long[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int N = 0; N < 10; N++) {
            StdOut.println(N + " " + F(N));
        }

        printLongArray(betterF(50));
    }
}
