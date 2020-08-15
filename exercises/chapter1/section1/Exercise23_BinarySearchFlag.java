/**
 * 1.1.23
 * Add to the BinarySearch test client the ability to respond to a second argument:+
 * to print numbers from standard input that are not in the whitelists, - to print
 * numbers that are in the whitelist.
 */
public class Exercise23_BinarySearchFlag {
    public static void printKeyInWhitelistOrNot(int[] whitelist, int key, String flag) {
        int result = rank(whitelist, key);
        if ((result > 0 && flag == "-") || (result < 0 && flag == "+")) System.out.println(key);
    }

    public static int rank(int[] whitelist, int key) {
        int lo = 0, hi = whitelist.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (whitelist[mid] == key) return mid;
            else if (whitelist[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] rank = new int[]{
                1, 2, 3, 4, 5, 6, 7, 9
        };
        printKeyInWhitelistOrNot(rank, 8, "+");     // print 8
        printKeyInWhitelistOrNot(rank, 9, "+");     // don't print 9
        printKeyInWhitelistOrNot(rank, 8, "-");     // don't print 8
        printKeyInWhitelistOrNot(rank, 9, "-");     // print 9
    }
}
