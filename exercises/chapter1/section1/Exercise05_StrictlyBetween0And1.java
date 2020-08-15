/**
 * 1.1.5
 * Write a code fragment that prints true if the double variables x and y are
 * both strictly between 0 and 1 and false otherwise.
 */
public class Exercise05_StrictlyBetween0And1 {
    public static void isStrictlyBetween0And1(double a, double b) {
        if ((a > 0 && a < 1) && (b > 0 && b < 1))
            System.out.println("true");
        else System.out.println("false");
    }

    public static void main(String[] args) {
        isStrictlyBetween0And1(0.1, 0.3);   // true
        isStrictlyBetween0And1(0, 0.4);     // false
        isStrictlyBetween0And1(0.5, 0);     // false
        isStrictlyBetween0And1(1, 0);       // false
    }
}
