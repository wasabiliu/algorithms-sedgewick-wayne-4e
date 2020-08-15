import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 1.1.39
 * Write a BinarySearch client that takes an int value T as command-line argument
 * and runs T trials of the following experiment for N=10^3, 10^4, 10^5 and 10^6:
 * generate two arrays of N randomly generated positive six-digit int values, and 
 * find the number of values that appear in both arrays. Print a table giving the 
 * average value of this quantity over the T trials for each of N.
 */
public class Exercise39_RandomMatches {

    public static int experiments(int N) {
        int[] a = new int[N];
        int[] b = new int[N];
        generateArray(a);
        generateArray(b);

        Arrays.sort(a);
        Arrays.sort(b);

        int both = 0;
        for (int i = 0; i < N; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;

            if (binarySearch(b, a[i], 0, N - 1)) both++;
        }
        return both;
    }

    private static void generateArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100000, 1000000);
        }
    }

    private static boolean binarySearch(int[] a, int key, int lo, int hi) {
        if (lo > hi) return false;
        int mid = (lo + hi) >>> 1;
        if (key < a[mid]) return binarySearch(a, key, lo, mid - 1);
        else if (key > a[mid]) return binarySearch(a, key, mid + 1, hi);
        else return true;
    }

    public static void main(String[] args) {
        int T = 4;

        int[] ns = new int[]{1000, 10000, 100000, 1000000};
        int[] result = new int[4];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < ns.length; j++) {
                result[j] += experiments(ns[j]);
            }
        }

        System.out.printf("%10s %37s\n", "Array Size", "AVG number of values in both arrays");
        System.out.printf("10^3 %17.2f \n", ((double) result[0] / T));
        System.out.printf("10^4 %17.2f \n", ((double) result[1] / T));
        System.out.printf("10^5 %17.2f \n", ((double) result[2] / T));
        System.out.printf("10^6 %17.2f \n", ((double) result[3] / T));
    }
}
