import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.9
 * Write a program that takes from standard input an expression without left
 * parentheses and prints the equivalent infix expression with the parentheses
 * inserted.
 */
public class Exercise09_AddLeftParentheses {
    public static String addLeftParentheses(String[] expression) {
        Stack<String> operand = new Stack<>();
        Stack<String> operation = new Stack<>();
        for (String s : expression) {
            if (isOperation(s)) {
                operation.push(s);
            } else if (!s.equals(")")) {
                operand.push(s);
            } else {
                String subExpression = operand.pop();
                subExpression = operation.pop() + subExpression;
                subExpression = "(" + operand.pop() + subExpression + ")";
                operand.push(subExpression);
            }
        }
        return operand.pop();
    }

    private static boolean isOperation(String s) {
        return s.equals("+") || s.equals("-")
                || s.equals("*") || s.equals("/");
    }

    public static void main(String[] args) {
        String[] s = new String[]{
                "1", "+", "2", ")", "*", "3", "-", "4", ")", "*", "5", "-", "6", ")", ")", ")"
        };
        System.out.println(addLeftParentheses(s));
    }
}
