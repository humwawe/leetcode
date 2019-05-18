package minimum.window.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int left = 0, right = 0;
        int required = dictT.size();
        int min = -1;
        int formed = 0;

        String result = "";
        Map<Character, Integer> dictWindow = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = dictWindow.getOrDefault(c, 0);
            dictWindow.put(c, count + 1);
            if (dictT.containsKey(c) && dictT.get(c).equals(dictWindow.get(c))) {
                formed++;
            }
            right++;

            while (left < right && formed == required) {
                if (min == -1 || min > right - left) {
                    result = s.substring(left, right);
                    min = right - left;
                }
                c = s.charAt(left);
                dictWindow.put(c, dictWindow.get(c) - 1);
                if (dictT.containsKey(c) && dictWindow.get(c) < dictT.get(c)) {
                    formed--;
                }
                left++;
            }
        }
        return result;
    }
}
