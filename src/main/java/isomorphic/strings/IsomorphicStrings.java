package isomorphic.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        return helper(s, t, map) && helper(t, s, map);
    }

    private boolean helper(String s, String t, Map<Character, Character> map) {
        map.clear();
        for (int i = 0; i < s.length(); i++) {
            char tmp1 = s.charAt(i);
            char tmp2 = t.charAt(i);
            if (map.containsKey(tmp1)) {
                if (map.get(tmp1) != tmp2) {
                    return false;
                }
            } else {
                map.put(tmp1, tmp2);
            }
        }
        return true;
    }
}
