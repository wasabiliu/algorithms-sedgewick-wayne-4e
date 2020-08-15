import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.1.35
 * Dice simulation.
 */
public class Exercise35_DiceSimulation {
    public static double[] diceSimulation(int N) {
        double[] dist=new double[13];
        for(int i=0;i<N;i++) {
            int a= StdRandom.uniform(1,7);
            int b=StdRandom.uniform(1,7);
            dist[a+b]++;
        }

        for(int i=1;i<13;i++)
            dist[i]/=N;
        return dist;
    }

    private static void printDiceResult(double[] dist) {
        for(int i=2;i<13;i++) {
            System.out.println(i+": "+dist[i]);
        }
    }

    public static void main(String[] args) {
        int N=1000000;
        printDiceResult(diceSimulation(N));
    }
}
