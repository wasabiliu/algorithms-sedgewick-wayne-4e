/**
 * 1.2.7
 * What does the following recursive function return?
 */
public class Exercise07_Mystery {
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        System.out.println(mystery("123456789"));   // 987654321
        System.out.println(mystery("abcdefgh"));    // hgfedcba
    }
}
