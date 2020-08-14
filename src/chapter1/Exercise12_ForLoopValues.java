/**
 * 1.1.12
 * What does the following code fragment print?
 */
public class Exercise12_ForLoopValues {
    public static void printForLoopValues() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) a[i] = 9 - i;
        for (int i = 0; i < 10; i++) a[i] = a[a[i]];
        for (int i = 0; i < 10; i++) System.out.println(i);
    }

    public static void main(String[] args) {
        printForLoopValues();   // 0 1 2 3 4 5 6 7 8 9
    }
}
