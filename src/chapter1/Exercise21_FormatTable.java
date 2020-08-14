import edu.princeton.cs.algs4.StdIn;

/**
 * 1.1.21
 * Write a program that reads in lines from standard input with each line containing
 * a name and two integers and then uses printf() to print a table with a column of
 * the names, the integers, and the result of dividing the first by the second, accurate
 * to three decimal places. You could use a program like this to tabulate batting
 * averages for baseball players or grades for students.
 */
public class Exercise21_FormatTable {
    public static void formatTable() {
        System.out.println("Name\tInteger A\tInteger B\tAvg");
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] fields = line.split(" ");
            String name = fields[0];
            int a = Integer.parseInt(fields[1]);
            int b = Integer.parseInt(fields[2]);
            double avg = (double) a / b;
            System.out.printf("%s\t%d\t%d\t%.3f\n", name, a, b, avg);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        formatTable();
    }
}
