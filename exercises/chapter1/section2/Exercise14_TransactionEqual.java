import edu.princeton.cs.algs4.Date;

/**
 * 1.2.14
 * Using our implementation of equals() in Date as a model, develop
 * implementations of equals() for Transaction.
 */
public class Exercise14_TransactionEqual {
    static class Transaction {
        private final String customer;
        private final edu.princeton.cs.algs4.Date date;
        private final double amount;

        public Transaction(String customer, edu.princeton.cs.algs4.Date date, double amount) {
            this.customer = customer;
            this.date = date;
            this.amount = amount;
        }

        public String getCustomer() {
            return customer;
        }

        public Date getDate() {
            return date;
        }

        public double getAmount() {
            return amount;
        }

        public String toString() {
            return String.format("%s %s %.2f", customer, date, amount);
        }

        public boolean equals(Object x) {
            if (this == x) return true;
            if (x == null) return false;
            if (this.getClass() != x.getClass()) return false;
            Transaction t = (Transaction) x;
            if (!this.customer.equals(t.customer)) return false;
            if (!this.date.equals(t.date)) return false;
            if (Double.compare(this.amount, t.getAmount()) != 0) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        Transaction a = new Transaction("valineliu", new Date(8, 15, 2020), 1.99);
        Transaction b = new Transaction("valineliu", new Date(8, 15, 2020), 1.99);
        System.out.println(a.equals(b));    // true
    }
}
