package longest.turbulent.subarray;

/**
 * @author hum
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] a) {
        int len = a.length;
        int[] dp = new int[len];
        dp[0] = 1;
        char prev = '=';
        int result = 0;
        for (int i = 1; i < len; i++) {
            if (a[i] > a[i - 1]) {
                if (prev == '<') {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 2;
                }
                prev = '>';
            } else if (a[i] < a[i - 1]) {
                if (prev == '>') {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 2;
                }
                prev = '<';
            } else if (a[i] == a[i - 1]) {
                dp[i] = 1;
                prev = '=';
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
