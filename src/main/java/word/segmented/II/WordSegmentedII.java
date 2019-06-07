package word.segmented.II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class WordSegmentedII {
    List<String> results = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
        helper(s, wordDict, 0, memo, "");
        return results;

    }

    private boolean helper(String s, List<String> wordDict, int index, int[] memo, String result) {
        if (index == s.length()) {
            results.add(result);
            return true;
        }
        if (memo[index] == -1) {
            return false;
        }
        boolean found = false;
        for (String word : wordDict) {
            int len = word.length() + index;
            if (len <= s.length() && s.substring(index, len).equals(word)) {
                if (helper(s, wordDict, len, memo, result.isEmpty() ? word : result + " " + word)) {
                    found = true;
                }

            }
        }
        if (!found) {
            memo[index] = -1;
            return false;
        } else {
            return true;
        }
    }
}
