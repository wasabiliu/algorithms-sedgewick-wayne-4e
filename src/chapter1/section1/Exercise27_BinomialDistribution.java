/**
 * 1.1.27
 * Estimate the number of recursive calls that would be used by the code.
 * Develop a better implementation that is based on saving computed values
 * in an array.
 */
public class Exercise27_BinomialDistribution {
    public static double binomialDistribution(int N, int k, double p) {
        double[][] result = new double[N + 1][k + 1];
        result[0][0] = 1.0;
        for (int j = 1; j <= k; j++) result[0][j] = 0;
        for (int i = 1; i <= N; i++) result[i][0] = result[i - 1][0] * (1 - p);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                result[i][j] = (1 - p) * result[i - 1][j] + p * result[i - 1][j - 1];
            }
        }
        return result[N][k];
    }

    // another implementation
    public static double binomialDistribution2(int N, int k, double p) {
        double[][] result = new double[N + 1][k + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                result[i][j] = -1;
            }
        }
        return binomialDistribution2(result, N, k, p);
    }

    private static double binomialDistribution2(double[][] result, int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        if (result[N][k] == -1) {
            result[N][k] = (1 - p) * binomialDistribution2(result, N - 1, k, p) +
                    p * binomialDistribution2(result, N - 1, k - 1, p);
        }
        return result[N][k];
    }

    public static void main(String[] args) {
        System.out.println(binomialDistribution(10, 10, 0.5));
        System.out.println(binomialDistribution2(10, 10, 0.5));
    }
}
