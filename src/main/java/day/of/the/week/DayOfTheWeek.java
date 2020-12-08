package day.of.the.week;


import java.util.Calendar;
import java.util.Locale;

/**
 * @author hum
 */
public class DayOfTheWeek {

    public String dayOfTheWeek(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
    }
}
