package word.segmented;

import java.util.List;

/**
 * @author hum
 */
public class WordSegmented {


    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
        return helper(s, wordDict, 0, memo);
    }

    private boolean helper(String s, List<String> wordDict, int index, int[] memo) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] == -1) {
            return false;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            int len = wordDict.get(i).length() + index;
            if (len <= s.length() && s.substring(index, len).equals(wordDict.get(i))) {
                if (helper(s, wordDict, len, memo)) {
                    return true;
                }
            }
        }

        memo[index] = -1;
        return false;
    }
}
