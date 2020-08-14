/**
 * 1.1.11
 * Write a code fragment that prints the contents of a two-dimensional boolean
 * array, using to represent true and space to represent false. Include row
 * and column numbers.
 */
public class Exercise11_PrintBooleanMatrix {
    public static void printBooleanMatrix(boolean[][] b) {
        if (b.length == 0) {
            return;
        }
        if (b[0].length == 0) {
            return;
        }

        // print column number
        int m = b.length, n = b[0].length;
        System.out.print("\t");
        for (int j = 0; j < n; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();

        // print content
        for (int i = 0; i < m; i++) {
            // print row number
            System.out.print(i + "\t");
            for (int j = 0; j < n; j++) {
                String s = "";
                if (b[i][j]) {
                    s = "*";
                } else {
                    s = " ";
                }
                System.out.print(s + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] a = new boolean[][]{
                {true, true, false, true, false},
                {true, false, false, true, true},
                {false, false, true, true, true},
                {true, false, false, false, true}
        };
        printBooleanMatrix(a);
    }
}
