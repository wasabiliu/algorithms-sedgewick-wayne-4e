/**
 * 1.1.14
 * Write a static method lg() that takes an int value N as argument and
 * returns the largest int not larger than the base-2 logarithm of N.
 * Do not use Math.
 */
public class Exercise14_LargestIntegerUnderLog {
    public static int largestIntegerUnderLog2(int N) {
        if (N < 0) return 0;
        int result = 0;
        for (int n = N; n > 1; n /= 2) result++;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestIntegerUnderLog2(1));     // 0
        System.out.println(largestIntegerUnderLog2(8));     // 3
        System.out.println(largestIntegerUnderLog2(15));    // 3
    }
}
