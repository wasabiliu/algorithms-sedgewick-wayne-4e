/**
 * 1.1.15
 * Write a static method histogram() that takes an array a[] of int values
 * and an integer M as arguments and returns an array of length M whose ith
 * entry is the number of times the integer i appeared in the argument array.
 * If the values in a[] are all between 0 and M-1, the sum of the values in
 * the returned array should be equal to a.length.
 */
public class Exercise15_Histogram {
    public static int[] histogram(int[] a, int M) {
        if (M < 0) return null;
        int[] result = new int[M];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < M) {
                result[a[i]]++;
            }
        }
        return result;
    }

    private static void printIntArray(int[] a) {
        for(int i=0;i<a.length;i++)
            System.out.printf("%d ",a[i]);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a=new int[] {
                1,1,2,2,2,4
        };
        printIntArray(histogram(a,5));  // 0 2 3 0 1
    }
}
