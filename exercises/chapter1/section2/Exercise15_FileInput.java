import edu.princeton.cs.algs4.In;

/**
 * 1.2.15
 * Develop a possible implementation of the static readInts() method from 
 * In (which we use for various test client, such as binary search) that
 * is based on the split() method in String.
 */
public class Exercise15_FileInput {
    public static int[] readInts(String name) {
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++)
            ints[i] = Integer.parseInt(words[i]);
        return ints;
    }

    public static void main(String[] args) {
        String fileName = "Exercise15_FileInput_Data.txt";
        int[] ints = readInts(fileName);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }
}
