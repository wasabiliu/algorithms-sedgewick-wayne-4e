/**
 * 1.2.5
 * What does the following code fragment print?
 */
public class Exercise05_PrintString2 {
    public static void printString() {
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        System.out.println(s);  // Hello World
    }

    public static void main(String[] args) {
        printString();
    }
}
