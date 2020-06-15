package maximum.number.of.occurrences.of.a.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MaximumNumberOfOccurrencesOfASubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        int[] t = new int[26];
        int count = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append(c);
            if (t[c - 'a'] == 0) {
                count++;
            }
            t[c - 'a']++;
            if (stringBuilder.length() < minSize) {
                continue;
            }
            if (stringBuilder.length() > minSize) {
                char tmp = stringBuilder.charAt(0);
                stringBuilder.deleteCharAt(0);
                t[tmp - 'a']--;
                if (t[tmp - 'a'] == 0) {
                    count--;
                }
            }
            if (stringBuilder.length() == minSize) {
                if (count <= maxLetters) {
                    map.put(stringBuilder.toString(), map.getOrDefault(stringBuilder.toString(), 0) + 1);
                }
            }
        }
        for (int v : map.values()) {
            result = Math.max(result, v);
        }
        return result;
    }
}
