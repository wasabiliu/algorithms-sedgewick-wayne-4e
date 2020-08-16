import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.3
 * Suppose that a client performs an intermixed sequence of (stack) push and pop
 * operations. The push operations put the integers 0 through 9 inorder onto the 
 * stack; the pop operations print out the return values. Which of the following 
 * sequence(s) could not occur?
 */
public class Exercise03_OperationSequence {
    public static boolean isValid(int[] push, int[] pop) {
        int n = 0;
        Stack<Integer> st = new Stack<>();
        for (int value : push) {
            st.push(value);
            while (!st.isEmpty() && n < push.length && st.peek() == pop[n]) {
                st.pop();
                n++;
            }
        }
        return n == push.length;
    }

    public static void main(String[] args) {
        int[] push = new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        int[][] pops = new int[][]{
                {4, 3, 2, 1, 0, 9, 8, 7, 6, 5},
                {4, 6, 8, 7, 5, 3, 2, 9, 0, 1},
                {2, 5, 6, 7, 4, 8, 9, 3, 1, 0},
                {4, 3, 2, 1, 0, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 9, 8, 7, 0},
                {0, 4, 6, 5, 3, 8, 1, 7, 2, 9},
                {1, 4, 7, 9, 8, 6, 5, 3, 0, 2},
                {2, 1, 4, 3, 6, 5, 8, 7, 9, 0}
        };
        for (int i = 0; i < pops.length; i++) {
            System.out.println((char) ('a' + i) + ": " + isValid(push, pops[i]));
        }
    }
}
