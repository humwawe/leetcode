package largest.sum.of.averages;

import java.util.Arrays;

/**
 * @author hum
 */
public class LargestSumOfAverages {
    double[][] memo;

    public double largestSumOfAverages(int[] arr, int k) {
        int len = arr.length;
        memo = new double[k + 1][len];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(arr, k, 0);
    }

    private double helper(int[] arr, int k, int prev) {
        if (memo[k][prev] != -1) {
            return memo[k][prev];
        }
        if (k == 1) {
            double tmp = 0;
            for (int i = prev; i < arr.length; i++) {
                tmp += arr[i];
            }
            return memo[k][prev] = tmp / (arr.length - prev);
        }
        double res = 0;
        for (int i = prev; i < arr.length - k + 1; i++) {
            double tmp = 0;
            for (int j = prev; j <= i; j++) {
                tmp += arr[j];
            }
            res = Math.max(res, tmp / (i - prev + 1) + helper(arr, k - 1, i + 1));
        }
        return memo[k][prev] = res;
    }
}
