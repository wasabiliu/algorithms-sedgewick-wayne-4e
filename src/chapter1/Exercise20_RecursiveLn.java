/**
 * 1.1.20
 * Write a recursive static method that computes the value of ln(N!).
 */
public class Exercise20_RecursiveLn {
    public static double ln(int N) {
        return Math.log(factorial(N));
    }

    public static long factorial(int N) {
        if (N == 1) return 1;
        return N * factorial(N - 1);
    }

    public static void main(String[] args) {
        System.out.println(ln(10));
        System.out.println(ln(20));
    }
}
