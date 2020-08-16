import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.4
 * Write a stack client Parentheses that reads in a text stream from 
 * standard input and uses a stack determine whether its parentheses
 * are properly balanced. For example, your program should print true
 * for [()]{}{[()()]()} and false for [(]).
 */
public class Exercise04_ValidParentheses {
    public static boolean validParentheses(String s) {
        Stack<Character> st = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') st.push(c);
            else {
                if (st.isEmpty()) return false;
                char t = st.pop();
                if (c == ')' && t != '(') return false;
                if (c == ']' && t != '[') return false;
                if (c == '}' && t != '{') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] items = new String[]{
                "[()]{}{[()()]()}",
                "[(])"
        };
        for (String s : items) {
            System.out.println(s + ": " + validParentheses(s));
        }
    }
}
