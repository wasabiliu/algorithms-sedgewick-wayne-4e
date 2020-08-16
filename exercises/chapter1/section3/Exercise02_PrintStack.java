import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.2
 * Give the output printed by java Stack for the input
 */
public class Exercise02_PrintStack {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        String[] items = new String[]{
                "it", "was", "-", "the", "best", "-", "of",
                "times", "-", "-", "-", "it", "was", "-",
                "the", "-", "-"
        };
        for (String item : items) {
            if (item.equals("-") && !s.isEmpty()) System.out.print(s.pop() + " ");
            else s.push(item);
        }
    }
}
