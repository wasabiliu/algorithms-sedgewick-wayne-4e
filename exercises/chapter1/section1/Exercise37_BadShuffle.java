import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.1.37
 * Suppose that you choose a random integer between 0 and N-1
 * in our shuffling code instead of between i and N-1.
 */
public class Exercise37_BadShuffle {
    public static void badShuffle(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int r = StdRandom.uniform(a.length);
            int temp = a[r];
            a[r] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args) {
        int N = 10;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        badShuffle(a);
    }
}
