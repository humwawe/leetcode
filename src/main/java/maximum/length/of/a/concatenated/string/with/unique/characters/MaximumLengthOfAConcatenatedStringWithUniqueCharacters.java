package maximum.length.of.a.concatenated.string.with.unique.characters;

import java.util.List;

/**
 * @author hum
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    public int maxLength(List<String> arr) {
        int len = arr.size();
        int[] count = new int[26];
        return helper(arr, 0, count);
    }

    private int helper(List<String> arr, int i, int[] count) {
        if (i == arr.size()) {
            return 0;
        }
        int res = helper(arr, i + 1, count);
        int[] tmp = new int[26];
        boolean f = true;
        for (char c : arr.get(i).toCharArray()) {
            tmp[c - 'a']++;
            if (tmp[c - 'a'] > 1) {
                f = false;
                break;
            }
            if (count[c - 'a'] > 0) {
                f = false;
                break;
            }
        }
        if (f) {
            for (int j = 0; j < 26; j++) {
                count[j] += tmp[j];
            }
            res = Math.max(res, helper(arr, i + 1, count) + arr.get(i).length());
            for (int j = 0; j < 26; j++) {
                count[j] -= tmp[j];
            }
        }
        return res;
    }
}
