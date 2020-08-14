/**
 * 1.1.30
 * Array exercise. Write a code fragment that creates an M-by-N boolean
 * array a[][] such that a[i][j] is true if i and j are relatively prime
 * (have no common factors), and false otherwise.
 */
public class Exercise30_ArrayExercise {

    public static boolean[][] generateCoprimeMatrix(int M, int N) {
        boolean[][] result = new boolean[M][N];

        // The only integers that are coprime to zero is 1 and -1.
        // See https://proofwiki.org/wiki/Integers_Coprime_to_Zero
        result[0][0] = true;
        result[0][1] = true;
        result[1][0] = true;
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                result[i][j] = gcd(i, j) == 1;
            }
        }
        return result;
    }

    private static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    private static void printBooleanMatrix(boolean[][] a) {
        if (a == null || a.length == 0) return;
        if (a[0].length == 0) return;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.printf("%6b", a[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] result = generateCoprimeMatrix(5, 5);
        printBooleanMatrix(result);
    }
}
