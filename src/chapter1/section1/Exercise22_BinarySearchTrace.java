/**
 * 1.1.22
 * Write a version of BinarySearch that uses the recursive rank() given on page
 * 25 and traces the method calls. Each time the recursive method is called, print
 * the argument values lo and hi, indented by the depth of the recursion. Hint: Add
 * an argument to the recursive method that keeps track of the depth.
 */
public class Exercise22_BinarySearchTrace {
    public static void binarySearchWithDepth(int[] a, int key) {
        System.out.println(rank(a, key, 0, a.length - 1, 0));
    }

    public static int rank(int[] a, int key, int lo, int hi, int depth) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        System.out.printf("%slo:%d, hi:%d\n", getIndents(depth), lo, hi);
        if (key > a[mid]) return rank(a, key, mid + 1, hi, depth + 1);
        else if (key < a[mid]) return rank(a, key, lo, mid - 1, depth + 1);
        else return mid;
    }

    private static String getIndents(int times) {
        String s = "";
        for (int i = 0; i < times; i++) s += "\t";
        return s;
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        binarySearchWithDepth(a, 8);
    }
}
