import java.util.Iterator;

/**
 * 1.3.8
 * Give the contents and size of the array for DoublingStackOfStrings 
 * with the input.
 */
public class Exercise08_SizeOfArrayStack {
    static class Stack<Item> implements Iterable<Item> {
        private Item[] a = (Item[]) new Object[1];
        private int N = 0;

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        private void resize(int max) {
            Item[] temp = (Item[]) new Object[max];
            for (int i = 0; i < N; i++)
                temp[i] = a[i];
            a = temp;
        }

        public Item pop() {
            Item item = a[--N];
            if (N > 0 && N == a.length / 4) resize(a.length / 2);
            a[N] = null;
            System.out.println("size: " + a.length);
            return item;
        }

        public void push(Item item) {
            if (N == a.length) resize(2 * a.length);
            a[N++] = item;
            System.out.println("size: " + a.length);
        }

        public Item peek() {
            return a[N - 1];
        }

        public Iterator<Item> iterator() {
            return new ReverseArrayIterator();
        }

        private class ReverseArrayIterator implements Iterator<Item> {
            private int i = N;

            public boolean hasNext() {
                return i > 0;
            }

            public Item next() {
                return a[--i];
            }

            public void remove() {

            }
        }
    }

    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        String[] items = new String[]{
                "it", "was", "-", "the", "best", "-", "of",
                "times", "-", "-", "-", "it", "was", "-",
                "the", "-", "-"
        };
        for (String s : items) {
            if (s.equals("-") && !st.isEmpty()) st.pop();
            else st.push(s);
        }
    }
}
