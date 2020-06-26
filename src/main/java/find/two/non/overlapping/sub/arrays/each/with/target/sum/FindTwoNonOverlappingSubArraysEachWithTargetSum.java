package find.two.non.overlapping.sub.arrays.each.with.target.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class FindTwoNonOverlappingSubArraysEachWithTargetSum {
    public int minSumOfLengths(int[] arr, int target) {
        int len = arr.length;
        int[] prevSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prevSum[i + 1] = arr[i] + prevSum[i];
        }
        int[] dp1 = new int[len + 1];
        Arrays.fill(dp1, (int) 1e8);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= len; i++) {
            dp1[i] = dp1[i - 1];
            if (map.containsKey(prevSum[i] - target)) {
                dp1[i] = Math.min(dp1[i - 1], i - map.get(prevSum[i] - target));
            }
            map.put(prevSum[i], i);
        }
        int[] lastSum = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            lastSum[i] = arr[i] + lastSum[i + 1];
        }
        int[] dp2 = new int[len + 1];
        Arrays.fill(dp2, (int) 1e8);
        map = new HashMap<>();
        map.put(0, len);
        for (int i = len - 1; i >= 0; i--) {
            dp2[i] = dp2[i + 1];
            if (map.containsKey(lastSum[i] - target)) {
                dp2[i] = Math.min(dp2[i + 1], map.get(lastSum[i] - target) - i);
            }
            map.put(lastSum[i], i);
        }

        int result = (int) 1e8;
        for (int i = 0; i < len; i++) {
            result = Math.min(result, dp1[i + 1] + dp2[i + 1]);
        }
        return result == (int) 1e8 ? -1 : result;
    }

    public int minSumOfLengths2(int[] arr, int target) {
        int len = arr.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = arr[i] + sum[i];
        }

        int result = (int) 1e8;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, (int) 1e8);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1];
            if (map.containsKey(sum[i] - target)) {
                int idx = map.get(sum[i] - target);
                dp[i] = Math.min(dp[i], i - idx);
                result = Math.min(result, dp[i] + dp[map.get(sum[i] - target)]);
            }
            map.put(sum[i], i);
        }
        return result == (int) 1e8 ? -1 : result;
    }
}
