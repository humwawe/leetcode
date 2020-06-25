package maximum.number.of.vowels.in.a.substring.of.given.length;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int len = s.length();
        int result = 0;
        int count = 0;
        int i = 0;
        for (; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }
        result = Math.max(result, count);
        while (i < len) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
            if (set.contains(s.charAt(i - k))) {
                count--;
            }
            result = Math.max(result, count);
            i++;
        }
        return result;
    }
}
