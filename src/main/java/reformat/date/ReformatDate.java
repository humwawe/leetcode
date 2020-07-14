package reformat.date;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class ReformatDate {
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        String[] month = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= month.length; i++) {
            map.put(month[i - 1], i);
        }
        String year = split[2];
        String mon = String.valueOf(map.get(split[1]));
        if (mon.length() < 2) {
            mon = "0" + mon;
        }
        StringBuilder day = new StringBuilder();
        for (char c : split[0].toCharArray()) {
            if (Character.isDigit(c)) {
                day.append(c);
            }
        }
        if (day.length() < 2) {
            day.insert(0, "0");
        }
        return year + "-" + mon + "-" + day.toString();
    }
}
