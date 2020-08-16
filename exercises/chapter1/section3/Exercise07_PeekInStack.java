import java.util.Iterator;

/**
 * 1.3.7
 * Add a method peek() to Stack that returns the most recently inserted 
 * item on the stack (without popping it).
 */
public class Exercise07_PeekInStack {
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
            return item;
        }

        public void push(Item item) {
            if (N == a.length) resize(2 * a.length);
            a[N++] = item;
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
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 10; i++) {
            st.push(i);
            System.out.println(st.peek());
        }
        System.out.println("size: " + st.size());
    }
}
