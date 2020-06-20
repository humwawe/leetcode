package find.the.longest.substring.containing.vowels.in.even.counts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class FindTheLongestSubstringContainingVowelsInEvenCounts {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        int len = s.length();
        int inf = (int) 1e8;
        int[] st = new int[32];
        Arrays.fill(st, inf);
        st[0] = -1;
        int result = 0;
        int state = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                state ^= 1 << map.get(s.charAt(i));
            }
            result = Math.max(result, i - st[state]);
            if (st[state] == inf) {
                st[state] = i;
            }
        }
        return result;
    }
}
