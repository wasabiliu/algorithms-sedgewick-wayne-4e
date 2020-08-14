/**
 * 1.1.29
 * Add to BinarySearch a static method rank() that takes a key and
 * a sorted array of int values (some of which may be equal) as
 * arguments and returns the number of elements that are smaller than
 * the key and a similar method count() that returns the number of
 * elements equal to that key. Note: If i and j are the values returned
 * by rank(key, a) and count(key, a) respectively, then a[i, i+j-1] are
 * the values in the array that are equal to key.
 */
public class Exercise29_EqualKeys {
    public static int rank(int[] a, int key) {
        return less(a, key, 0, a.length - 1);
    }

    public static int count(int[] a, int key) {
        return a.length - less(a, key, 0, a.length - 1)
                - greater(a, key, 0, a.length - 1);
    }

    private static int less(int[] a, int key, int lo, int hi) {
        if (lo > hi) return lo;
        int mid = (lo + hi) >>> 1;
        if (key > a[mid]) return less(a, key, mid + 1, hi);
        else return less(a, key, lo, mid - 1);
    }

    private static int greater(int[] a, int key, int lo, int hi) {
        if (lo > hi) return a.length - hi - 1;
        int mid = (lo + hi) >>> 1;
        if (key < a[mid]) return greater(a, key, lo, mid - 1);
        else return greater(a, key, mid + 1, hi);
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                1, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 7, 8, 9, 9
        };
        for (int key = 0; key <= 10; key++) {
            System.out.printf("# of numbers less than %d: %d\n", key, rank(a, key));
            System.out.printf("# of numbers equal to %d: %d\n", key, count(a, key));
        }
    }
}
