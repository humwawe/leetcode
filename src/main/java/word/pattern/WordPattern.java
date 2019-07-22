package word.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - '0';
            if (!map1.containsKey(index)) {
                map1.put(index, strs[i]);
            }
            if (!map2.containsKey(strs[i])) {
                map2.put(strs[i], index);
            }
            if (map2.get(strs[i]) != index || !map1.get(index).equals(strs[i])) {
                return false;
            }
        }
        return true;
    }
}
