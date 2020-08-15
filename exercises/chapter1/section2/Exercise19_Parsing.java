import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Transaction;

/**
 * 1.2.19
 * Develop the parse constructors for your Date and Transaction 
 * implementations that take a single String argument to specify
 * the initialization values.
 */
public class Exercise19_Parsing {
    public static Date parseDate(String date) {
        String[] fields = date.split("/");
        int month = Integer.parseInt(fields[0]);
        int day = Integer.parseInt(fields[1]);
        int year = Integer.parseInt(fields[2]);
        return new Date(month, day, year);
    }

    public static Transaction parseTransaction(String transaction) {
        String[] fields = transaction.split(" ");
        String customer = fields[0];
        Date date = parseDate(fields[1]);
        double amount = Double.parseDouble(fields[2]);
        return new Transaction(customer, date, amount);
    }

    public static void main(String[] args) {
        String d = "5/22/1939";
        String t = "Turing 5/22/1939 11.99";
        Date date = parseDate(d);
        Transaction transaction = parseTransaction(t);
        System.out.println(date);
        System.out.println(transaction);
    }
}
