package largest.substring.between.two.equal.characters;

import java.util.Arrays;

/**
 * @author hum
 */
public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int result = -1;
        int[] start = new int[26];
        Arrays.fill(start, -1);
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            int idx = arr[i] - 'a';
            if (start[idx] == -1) {
                start[idx] = i;
            } else {
                result = Math.max(result, i - start[idx] - 1);
            }
        }
        return result;
    }
}
