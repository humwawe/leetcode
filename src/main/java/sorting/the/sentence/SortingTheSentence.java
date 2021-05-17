package sorting.the.sentence;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class SortingTheSentence {
    public String sortSentence(String s) {
        String[] s1 = s.split(" ");
        Arrays.sort(s1, Comparator.comparingInt(x -> x.charAt(x.length() - 1)));
        StringBuilder sb = new StringBuilder();
        for (String value : s1) {
            sb.append(value, 0, value.length() - 1).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
