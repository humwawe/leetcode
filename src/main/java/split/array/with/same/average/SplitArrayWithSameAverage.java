package split.array.with.same.average;

/**
 * @author hum
 */
public class SplitArrayWithSameAverage {
    public boolean splitArraySameAverage(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        boolean[][] dp = new boolean[len][sum + 1];
        dp[0][0] = true;

        for (int num : arr) {
            for (int k = len - 1; k >= 1; k--) {
                for (int j = 0; j <= sum; j++) {
                    if (j >= num && dp[k - 1][j - num]) {
                        dp[k][j] = true;
                        if (sum * k == j * len) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
