import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.11
 * Write a program EvaluatePostfix that takes a postfix expression from 
 * standard input, evaluates it, and prints the value.
 */
public class Exercise11_EvaluatePostfix {
    public static double evaluatePostfix(String[] expression) {
        Stack<Double> operator = new Stack<>();
        for (String s : expression) {
            switch (s) {
                case "+": {
                    double b = operator.pop();
                    double t = operator.pop() + b;
                    operator.push(t);
                    break;
                }
                case "-": {
                    double b = operator.pop();
                    double t = operator.pop() - b;
                    operator.push(t);
                    break;
                }
                case "*": {
                    double b = operator.pop();
                    double t = operator.pop() * b;
                    operator.push(t);
                    break;
                }
                case "/": {
                    double b = operator.pop();
                    double t = operator.pop() / b;
                    operator.push(t);
                    break;
                }
                default:
                    operator.push(Double.parseDouble(s));
                    break;
            }
        }
        return operator.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostfix("1 2 + 3 4 - 5 6 - * *".split(" ")));
    }
}
