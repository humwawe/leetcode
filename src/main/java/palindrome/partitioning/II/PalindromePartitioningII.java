package palindrome.partitioning.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class PalindromePartitioningII {

    public int minCut(String s) {
//        int[][] memo = new int[s.length() + 1][s.length() + 1];
//        for (int i = 0; i < memo.length; i++) {
//            Arrays.fill(memo[i], -1);
//        }
//        return helper(s, 0, s.length(), memo);


//        if (s == null || s.length() <= 1) {
//            return 0;
//        }
//        int len = s.length();
//        int[] dp = new int[len];
//        Arrays.fill(dp, len - 1);
//        for (int i = 0; i < len; i++) {
//            helper2(s, i, i, dp);
//            helper2(s, i, i + 1, dp);
//        }
//        return dp[len - 1];

        if (isPalindrome(s)) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        Arrays.fill(dp, len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    if (j == 0) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[len - 1];

    }

    private void helper2(String s, int i, int j, int[] dp) {
        int len = s.length();
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            dp[j] = Math.min(dp[j], (i == 0 ? -1 : dp[i - 1]) + 1);
            i--;
            j++;
        }
    }

    private int helper(String s, int i, int j, int[][] memo) {
        if (isPalindrome(s.substring(i, j))) {
            memo[i][j] = 0;
            return 0;
        }
        int tmp = Integer.MAX_VALUE;
        for (int index = i + 1; index < j; index++) {
            int left = memo[i][index] == -1 ? helper(s, i, index, memo) : memo[i][index];
            int right = memo[index][j] == -1 ? helper(s, index, j, memo) : memo[index][j];

            tmp = Math.min(left + right + 1, tmp);
        }

        memo[i][j] = tmp;
        return tmp;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
