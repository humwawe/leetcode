package print.words.vertically;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PrintWordsVertically {
    public List<String> printVertically(String s) {
        String[] split = s.split(" ");
        int len = 0;
        for (String s1 : split) {
            len = Math.max(len, s1.length());
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < split.length; j++) {
                if (split[j].length() <= i) {
                    tmp.append(" ");
                } else {
                    tmp.append(String.valueOf(split[j].charAt(i)));
                }
            }
            for (int j = tmp.length() - 1; j >= 0; j--) {
                if (tmp.charAt(j) == ' ') {
                    tmp.deleteCharAt(j);
                } else {
                    break;
                }
            }
            result.add(tmp.toString());
        }
        return result;
    }
}
