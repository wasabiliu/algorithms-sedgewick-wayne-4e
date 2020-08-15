/**
 * 1.1.9
 * Write a code fragment that puts the binary representation of a positive
 * integer N into a String s.
 */
public class Exercise09_ToBinaryString {
    public static String toBinaryString(int N) {
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;
        return s;
    }

    public static void main(String[] args) {
        System.out.println(toBinaryString(1));      // 1
        System.out.println(toBinaryString(15));     // 1111
        System.out.println(toBinaryString(1024));   // 10000000000
        System.out.println(toBinaryString(65534));  // 1111111111111110
    }
}
