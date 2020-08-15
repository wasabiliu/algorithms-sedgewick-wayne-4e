import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.7
 * Give the value printed by each of the following fragments.
 */
public class Exercise07_PrintValues {
    public static void codeSegment1() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    public static void codeSegment2() {
        int sum = 0;
        for (int i = 0; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }

    public static void codeSegment3() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        StdOut.println(sum);
    }

    public static void main(String[] args) {
        codeSegment1(); // 3.0009
        codeSegment2(); // 499500
        codeSegment3(); // 10000
    }
}
