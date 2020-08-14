/**
 * 1.1.28
 * Remove any duplicate keys in the array.
 */
public class Exercise28_RemoveDuplicates {
    public static void removeDuplicates(int[] a) {
        int[] b = new int[a.length];
        b[0] = a[0];
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != b[count]) {
                count++;
                b[count] = a[i];
            }
        }
        count++;
        int[] result = new int[count];
        System.arraycopy(b, 0, result, 0, count);
        printIntArray(result);
    }

    private static void printIntArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] duplicates = new int[]{
                1, 2, 2, 3, 4, 5, 5, 5, 6, 7, 7, 8, 8, 9, 9, 10
        };
        removeDuplicates(duplicates);
    }
}
