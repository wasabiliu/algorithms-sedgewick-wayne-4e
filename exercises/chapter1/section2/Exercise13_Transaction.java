import edu.princeton.cs.algs4.Date;

/**
 * 1.2.14
 * Using our implementation of Date as a model, develop an implementation of
 * Transaction.
 */
public class Exercise13_Transaction {
    static class Transaction {
        private final String customer;
        private final Date date;
        private final double amount;

        public Transaction(String customer, Date date, double amount) {
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
    }

    public static void main(String[] args) {
        Transaction t = new Transaction("valineliu", new Date(8, 15, 2020), 19.99);
        System.out.println(t);
    }
}
