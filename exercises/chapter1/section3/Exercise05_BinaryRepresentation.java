import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.5
 * What does the following code fragment print when N is 50? Give 
 * a high-level description of what it does when presented with a
 * positive integer N.
 */
public class Exercise05_BinaryRepresentation {
    public static String binaryRepresentation(int N) {
        Stack<Integer> st = new Stack<>();
        while (N > 0) {
            st.push(N % 2);
            N /= 2;
        }
        StringBuilder s = new StringBuilder();
        for (int d : st) s.append(d);
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(binaryRepresentation(50));
    }
}
