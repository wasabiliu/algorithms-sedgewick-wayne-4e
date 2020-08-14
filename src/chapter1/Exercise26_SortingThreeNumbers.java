/**
 * 1.1.26
 * Suppose that the variables a,b,c, and t are all of the same
 * numeric primitive type. Show that the following code puts a,
 * b, and c in ascending order.
 */
public class Exercise26_SortingThreeNumbers {
    public static void sortingThreeIntegers(int a, int b, int c) {
        int t;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        ;
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        System.out.println(a + " " + b + " " + c);
    }

    public static void main(String[] args) {
        sortingThreeIntegers(9, 2, 4);
    }
}
