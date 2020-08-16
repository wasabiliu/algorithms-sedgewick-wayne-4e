import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.6
 * What does the following code fragment do to the queue q?
 */
public class Exercise06_ReverseQueue {

    private static void printQueue(Queue<Integer> q) {
        for (int d : q) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        for (int i = 0; i < 10; i++) q.enqueue(i);

        System.out.println("before operation:");
        printQueue(q);

        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());

        System.out.println("after operation:");
        printQueue(q);
    }
}
