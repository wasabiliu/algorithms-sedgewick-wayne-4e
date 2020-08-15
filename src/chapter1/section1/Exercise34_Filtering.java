import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1.1.34
 * Which of the following require saving all the values from standard
 * input (in an array, say), and which could be implemented as a filter
 * using only a fixed number of variables and arrays of fixed size (not
 * dependent on N)? For each, the input comes from standard input and 
 * consists of N numbers between 0 and 1.
 */

public class Exercise34_Filtering {
    /**
     * Print the maximum and minimum numbers
     * Can be implemented as filter.
     */
    public static void minmax(double[] a) {
        if (a == null || a.length == 0) return;
        double min = a[0];
        double max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) min = a[i];
            if (max < a[i]) max = a[i];
        }
        System.out.printf("min is %f, max is %f\n", min, max);
    }

    /**
     * Print the median of the numbers.
     * Should save all the numbers.
     */
    public static void median(double[] a) {
        if (a == null || a.length == 0) return;
        Arrays.sort(a);
        if (a.length % 2 == 1) System.out.println("median is: " + a[a.length / 2]);
        else System.out.println("median is: " + (a[a.length / 2 - 1] + a[a.length / 2]) / 2);
    }

    /**
     * Print the kth smallest value, for k less than 100.
     * Can be implemented as a filter, need to save k numbers.
     */
    public static void kthSmallest(double[] a,int k) {
        if(a==null||k>a.length) return;
        PriorityQueue<Double> pq=new PriorityQueue<>(k);
        for(int i=0;i<a.length;i++)
            pq.add(a[i]);
        for(int i=0;i<k-1;i++){
            pq.remove();
        }
        System.out.println(pq.remove());
    }

    /**
     * Print the sum of the squares of the numbers.
     * Can be implemented as a filter.
     */
    public static void sumOfSquare(double[] a) {
        if(a==null||a.length==0) return;
        double sum=0;
        for(int i=0;i<a.length;i++)
            sum+=a[i]*a[i];
        System.out.println("sum of square is: "+sum);
    }

    /**
     * Print the average of the N numbers.
     * Can be implemented as a filter.
     */
    public static void average(double[] a) {
        if(a==null||a.length==0) return;
        double sum=0;
        for(int i=0;i<a.length;i++)
            sum+=a[i]*a[i];
        double average=sum/a.length;
        System.out.println("average is: "+average);
    }

    /**
     * Print the percentage of numbers greater than the average.
     * Need to save all numbers.
     */
    public static void percentage(double[] a) {
        if(a==null||a.length==0) return;
        double sum=0;
        for(int i=0;i<a.length;i++)
            sum+=a[i]*a[i];
        double average=sum/a.length;
        int count=0;
        for(int i=0;i<a.length;i++)
            if(a[i]>average) count++;
        System.out.println("percentage of numbers greater than the average is: "+count*1.0/a.length);
    }

    /**
     * Print the N numbers in increasing order.
     * Need to save all numbers.
     * 
     * Print the N numbers in random order.
     * Also need to save all numbers.
     */
    public static void increasing(double[] a) {
        Arrays.sort(a);
    }

    private static void printDoubleArray(double[] a) {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 10;

        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        System.out.println("the array is:");
        printDoubleArray(a);

        double[] b=Arrays.copyOf(a,a.length);
        Arrays.sort(b);
        System.out.println("the sorted array is");
        printDoubleArray(b);

        // test minmax
        minmax(a);

        // test median
        median(a);

        // test kth smallest
        kthSmallest(a,3);

        // test sum of square
        sumOfSquare(a);

        // test average
        average(a);

        // test percentage
        percentage(a);
    }
}
