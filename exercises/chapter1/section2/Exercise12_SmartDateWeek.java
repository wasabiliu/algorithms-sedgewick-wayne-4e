import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 1.2.12
 * Add a method dayOfTheWeek() to SmartDate that returns a Sting value Monday,
 * Tuesday, Wednesday, Thursday, Saturday, or Sunday, giving the appropriate
 * day of the week for the date. You may assume that the date is in the 21st
 * century.
 */
public class Exercise12_SmartDateWeek {
    static class SmartDate {
        private final int year;
        private final int month;
        private final int day;
        private final Date date;

        public SmartDate(int year, int month, int day) throws IllegalArgumentException {
            this.year = year;
            this.month = month;
            this.day = day;
            try {
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                df.setLenient(false);
                date = df.parse(this.toString());
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
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

        public String dayOfTheWeek() {
            String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int week = c.get(Calendar.DAY_OF_WEEK);
            return days[week - 1];
        }

        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }

    public static void main(String[] args) {
        SmartDate date = new SmartDate(2020, 8, 15);
        System.out.println(date);                   // 8/18/2020
        System.out.println(date.dayOfTheWeek());    // Saturday
    }
}
