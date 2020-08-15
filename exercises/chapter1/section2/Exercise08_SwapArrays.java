/**
 * 1.2.8
 * Suppose that a[] and b[] are each integer arrays consisting of millions
 * of integers. What does the follow code do? Is it reasonably efficient?
 *      int[] t = a; a= b; b= t;
 * It swaps them. It could hardly be more efficient because it does so by
 * copying references, so that it is not necessary to copy millions of 
 * elements.
 */
public class Exercise08_SwapArrays {

    private static void printIntArray(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("before swap:");
        printIntArray(a);
        printIntArray(b);

        int[] t = a;
        a = b;
        b = t;

        System.out.println("after swap:");
        printIntArray(a);
        printIntArray(b);
    }
}
