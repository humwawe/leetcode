package longest.substring.without.repeating.characters;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int point1 = 0, point2 = 0;
        int result = 0;
        int length = 0;
        Set<Character> cacheSet = new HashSet<Character>();
        while (point2 < s.length()) {
            if (!cacheSet.contains(s.charAt(point2))) {
                cacheSet.add(s.charAt(point2++));
                length++;
                if (result < length) {
                    result = length;
                }
            } else {
                cacheSet.remove(s.charAt(point1++));
                length--;
            }
        }
        return result;
    }
}
