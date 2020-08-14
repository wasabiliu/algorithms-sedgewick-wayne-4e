/**
 * 1.1.13
 * Write a code fragment to print the transposition (rows and columns changed)
 * of a two-dimensional array with M rows and N columns.
 */
public class Exercise13_Transposition {
    public static void printTransposition(int[][] a) {
        if (a.length == 0) return;
        if (a[0].length == 0) return;
        for (int j = 0; j < a[0].length; j++) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        printTransposition(a);
    }
}
