package count.number.of.texts;

/**
 * @author hum
 */
public class CountNumberOfTexts {
  public int countTexts(String pressedKeys) {
    int mod = (int) (1e9 + 7);
    int len = pressedKeys.length();
    char[] arr = pressedKeys.toCharArray();
    int[] dp = new int[len + 1];
    dp[0] = 1;
    for (int i = 1; i <= len; i++) {
      dp[i] = dp[i - 1];
      if (i >= 2 && arr[i - 1] == arr[i - 2]) {
        dp[i] = (dp[i] + dp[i - 2]) % mod;
      }
      if (i >= 3 && arr[i - 1] == arr[i - 3] && arr[i - 1] == arr[i - 2]) {
        dp[i] = (dp[i] + dp[i - 3]) % mod;
      }
      if ((arr[i - 1] == '7' || arr[i - 1] == '9') && i >= 4 && arr[i - 1] == arr[i - 4] && arr[i - 1] == arr[i - 3] && arr[i - 1] == arr[i - 2]) {
        dp[i] = (dp[i] + dp[i - 4]) % mod;
      }
    }
    return dp[len];
  }
}
