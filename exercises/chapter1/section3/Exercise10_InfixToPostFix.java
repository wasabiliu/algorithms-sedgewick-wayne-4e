import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.10
 * Write a filter InfixToPostfix that takes a postfix expression from 
 * infix to postfix.
 */
public class Exercise10_InfixToPostfix {
    public static String infixToPostfix(String[] expression) {
        Stack<String> operand = new Stack<>();
        Stack<String> operation = new Stack<>();
        for (String s : expression) {
            if (isOperation(s)) {
                operation.push(s);
            } else if (s.equals("(")) {
            } else if (s.equals(")")) {
                String subExpression = operand.pop() + " " + operation.pop();
                subExpression = operand.pop() + " " + subExpression;
                operand.push(subExpression);
            } else {
                operand.push(s);
            }
        }
        return operand.pop();
    }

    private static boolean isOperation(String s) {
        return s.equals("+") || s.equals("-")
                || s.equals("*") || s.equals("/");
    }

    public static void main(String[] args) {
        String[] expression = new String[]{
                "(", "(", "1", "+", "2", ")", "*", "(", "(", "3", "-",
                "4", ")", "*", "(", "5", "-", "6", ")", ")", ")"
        };
        System.out.println(infixToPostfix(expression)); // 1 2 + 3 4 - 5 6 - * *
    }
}
