package longest.ideal.subsequence;

/**
 * @author hum
 */
public class LongestIdealSubsequence {
  public int longestIdealString(String s, int k) {
    int[] dp = new int[26];
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      int max = 0;
      int cur = s.charAt(i) - 'a';
      for (int j = 0; j < 26; j++) {
        if (Math.abs(cur - j) <= k) {
          max = Math.max(max, dp[j] + 1);
        }
      }
      res = Math.max(res, max);
      dp[cur] = Math.max(dp[cur], max);
    }
    return res;
  }
}
