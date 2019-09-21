package longest.substring.with.at.least.k.repeating.characters;

/**
 * @author hum
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int[][] memo = new int[len + 1][len + 1];
        return helper(charArray, k, 0, len, memo);
    }

    private int helper(char[] arr, int k, int start, int end, int[][] memo) {
        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            char c = arr[i];
            count[c - 'a']++;
        }
        for (int i = start; i < end; i++) {
            char c = arr[i];
            if (count[c - 'a'] < k) {
                memo[start][end] = Math.max(helper(arr, k, start, i, memo), helper(arr, k, i + 1, end, memo));
                return memo[start][end];
            }
        }
        memo[start][end] = end - start;
        return end - start;
    }
}
