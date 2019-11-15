package longest.uncommon.subsequence.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (strs[i].length() <= strs[j].length() && i != j && helper(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private boolean helper(String str1, String str2) {
        int j = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(j)) {
                j++;
                if (j == str1.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
