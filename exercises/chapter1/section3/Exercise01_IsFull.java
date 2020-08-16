/**
 * 1.3.1
 * Add a method isFull() to FixedCapacityStackOfStrings.
 */
public class Exercise01_IsFull {
    static class FixedCapacityStackOfStrings {
        private String[] a;
        private int N;

        public FixedCapacityStackOfStrings(int cap) {
            a = new String[cap];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public boolean isFull() {
            return N == a.length;
        }

        public int size() {
            return N;
        }

        public void push(String item) {
            a[N++] = item;
        }

        public String pop() {
            return a[--N];
        }
    }

    public static void main(String[] args) {
        int N = 4;
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(N);
        for (int i = 0; i < N; i++) {
            System.out.println("push item: " + i);
            s.push(String.valueOf(i));
            System.out.println(s.isFull());
        }
    }
}
