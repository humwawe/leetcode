package number.of.days.between.two.dates;

/**
 * @author hum
 */
public class NumberOfDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(isday(date1) - isday(date2));
    }

    public int isday(String date) {
        int i, d = 0;
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (i = 1971; i <= Integer.valueOf(date.substring(0, 4)); i++) {
            d += (i % 4 == 0 && i % 100 != 0) || i % 400 == 0 ? 366 : 365;
        }
        i--;
        if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            days[1] = 29;
        }
        for (int j = 11; j >= Integer.valueOf(date.substring(5, 7)) - 1; j--) {
            d -= days[j];
        }
        return d + Integer.valueOf(date.substring(8));
    }
}
