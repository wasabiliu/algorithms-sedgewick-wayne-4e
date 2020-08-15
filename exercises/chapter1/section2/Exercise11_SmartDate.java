import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 1.2.11
 * Develop an implementation SmartDate of our Date API that raises an exception
 * if the date is not legal.
 */
public class Exercise11_SmartDate {
    static class SmartDate {
        private final int year;
        private final int month;
        private final int day;

        public SmartDate(int year, int month, int day) throws IllegalArgumentException {
            this.year = year;
            this.month = month;
            this.day = day;
            if (!isValid()) throw new IllegalArgumentException();
        }

        public int year() {
            return year;
        }

        public int month() {
            return month;
        }

        public int day() {
            return day;
        }

        private boolean isValid() {
            try {
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                df.setLenient(false);
                df.parse(this.toString());
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }

    public static void main(String[] args) {
        SmartDate d = new SmartDate(1999, 12, 31);
        System.out.println(d);
    }
}
