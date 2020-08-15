/**
 * 1.1.24
 * Give the sequence of values of p and q that are computed when Euclid's
 * algorithm is used to compute the greatest common divisor of 105 and 24.
 * Extend the code given on page 4 to develop a program Euclid that takes
 * two integers from the command line and computes their greatest common
 * divisor, printing out the two arguments for each call on the recursive
 * method. Use your program to compute the greatest common divisor of
 * 1111111 and 1234567.
 */
public class Exercise24_EuclidAlgorithm {
    public static int gcdWithoutRecursion(int p, int q) {
        while (q != 0) {
            System.out.println(p + "\t" + q);
            int r = p % q;
            p = q;
            q = r;
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(gcdWithoutRecursion(105,24));
        System.out.println(gcdWithoutRecursion(1111111,1234567));
    }
}
