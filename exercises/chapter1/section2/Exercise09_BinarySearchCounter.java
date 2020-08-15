import edu.princeton.cs.algs4.Counter;

/**
 * 1.2.9
 * Instrument BinarySearch to use a Counter to count the total number of keys
 * examined during all searches and then print the total after all searches
 * are complete.
 * Hint: Create a Counter in main() and pass it as an argument to rank().
 */
public class Exercise09_BinarySearchCounter {
    public static int binarySearchCounter(int[] a, int key, Counter counter) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            counter.increment();
            if (key == a[mid]) return mid;
            else if (key < a[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Counter counter = new Counter("BinarySearch");
        int[] a = new int[]{
                1, 2, 3, 4, 5, 6, 7, 9
        };
        System.out.println(binarySearchCounter(a, 8, counter)); // -1
        System.out.println(counter);    // 4
    }
}
