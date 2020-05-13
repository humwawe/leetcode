package longest.string.chain;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int len = words.length;
        int[] dp = new int[len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (helper(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    private boolean helper(String w1, String w2) {
        if (w1.length() + 1 != w2.length()) {
            return false;
        }
        for (int i = 0; i < w2.length(); i++) {
            if (w1.contentEquals(new StringBuilder(w2).deleteCharAt(i))) {
                return true;
            }
        }
        return false;
    }
}
