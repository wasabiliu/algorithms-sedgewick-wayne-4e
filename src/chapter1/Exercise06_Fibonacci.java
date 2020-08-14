import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.6
 * What does the following program prints? (This is a fibonacci list
 * actually)
 */
public class Exercise06_Fibonacci {
    public static void printFibonacci() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public static void main(String[] args) {
        printFibonacci();
    }
}
