/**
 * 1.1.3
 * Write a program that takes three integer command-line arguments and prints equal if all
 * three are equal, and not equal otherwise.
 */
public class Exercise03_EqualAmongThreeIntegers {
    public static String equalAmongThreeIntegers(int a, int b, int c) {
        if (a == b && b == c) return "equal";
        else return "not equal";
    }

    public static void main(String[] args) {
        System.out.println(equalAmongThreeIntegers(1, 2, 3));   // not equal
        System.out.println(equalAmongThreeIntegers(1, 1, 2));   // not equal
        System.out.println(equalAmongThreeIntegers(1, 2, 2));   // not equal
        System.out.println(equalAmongThreeIntegers(1, 2, 1));   // not equal
        System.out.println(equalAmongThreeIntegers(1, 1, 1));   // equal
    }
}
