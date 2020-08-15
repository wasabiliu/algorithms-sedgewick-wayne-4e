/**
 * 1.1.33
 * Write a library Matrix that implements the following API.
 * Develop a test client that reads values from standard input
 * and tests all the methods.
 */
public class Exercise33_Matrix {

    /**
     * vector dot product: x.length should equal to y.length
     */
    public static double dot(double[] x, double[] y) {
        if (x == null || y == null || x.length != y.length)
            throw new IllegalArgumentException();
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }

    /**
     * matrix-matrix product: column number of a should be equal
     * to row number of b
     */
    public static double[][] mult(double[][] a, double[][] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0 ||
                a[0].length != b.length) {
            throw new IllegalArgumentException();
        }
        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    /**
     * transpose
     */
    public static double[][] transpose(double[][] a) {
        if (a == null)
            throw new IllegalArgumentException();
        if (a.length == 0) return a;
        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[j][i] = a[i][j];
        return result;
    }

    /**
     * matrix-vector product: column number of a should equal to
     * length of x
     */
    public static double[] mult(double[][] a,double[] x) {
        if(a==null||x==null||a.length==0||a[0].length!=x.length)
            throw new IllegalArgumentException();
        double[] result=new double[a.length];
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                result[i]+=a[i][j]*x[j];
            }
        }
        return result;
    }

    /**
     * vector-matrix product: length of y should equal to row
     * number of a
     */
    public static double[] mult(double[] y,double[][] a) {
        if(y==null ||a==null||y.length!=a.length)
            throw  new IllegalArgumentException();
        double[] result;
        result = new double[a[0].length];
        for(int i=0;i<a[0].length;i++) {
            for(int j=0;j<a.length;j++) {
                result[i]+=y[j]*a[j][i];
            }
        }
        return result;
    }

    private static void printMatrix(double[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    private static void printDoubleArray(double[] a) {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        // test vector dot product
        double[] x = new double[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        double[] y = new double[]{
                9, 8, 7, 6, 5, 4, 3, 2, 1
        };
        System.out.println("vector dot product result:");
        System.out.println(dot(x, y));

        // test matrix-matrix product
        double[][] a = new double[][]{
                {1, 2, 3},
                {4, 5, 6},
        };
        double[][] b = new double[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println("matrix-matrix product result:");
        printMatrix(mult(a, b));

        // test matrix transpose
        System.out.println("matrix transpose result:");
        printMatrix(transpose(a));

        // test matrix-vector product
        double[] xx=new double[] {
                4,5,6
        };
        System.out.println("matrix-vector product result:");
        printDoubleArray(mult(a,xx));

        // test vector-matrix product
        System.out.println("vector-matrix product result:");
        printDoubleArray(mult(xx,b));
    }
}
