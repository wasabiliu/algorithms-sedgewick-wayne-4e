/**
 * 1.2.4
 * What does the following code fragment print?
 */
public class Exercise04_PrintString {
    public static void printString() {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        System.out.println(string1);    // world
        System.out.println(string2);    // hello
    }

    public static void main(String[] args) {
        printString();
    }
}
