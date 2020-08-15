/**
 * 1.1.38
 * Write a program BruteForceSearch.
 */
public class Exercise38_BruteForceSearch {
    public static int bruteForceSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        System.out.println(bruteForceSearch(a, 9));
    }
}
