import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.1.36
 * Empirical Shuffle Check
 */
public class Exercise36_EmpiricalShuffleCheck {
    public static void shuffle(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int r = i + StdRandom.uniform(a.length - i);
            int temp = a[r];
            a[r] = a[i];
            a[i] = temp;
        }
    }

    private static void init(int[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = i;
    }

    private static void printTable(int[][] position) {
        for (int i = 0; i < position.length; i++) {
            System.out.printf("%3d\t", i);
            for (int j = 0; j < position[0].length; j++) {
                System.out.printf("%5d\t", position[i][j]);
            }
            System.out.println();
        }
    }

    public static void shuffleTest(int M, int N) {
        int[] a = new int[M];
        init(a);

        int[][] position = new int[M][M];
        for (int i = 0; i < N; i++) {
            shuffle(a);
            for (int j = 0; j < a.length; j++)
                position[a[j]][j]++;
        }

        printTable(position);
    }

    public static void main(String[] args) {
        int M = 10, N = 10;
        shuffleTest(M, N);
    }
}
