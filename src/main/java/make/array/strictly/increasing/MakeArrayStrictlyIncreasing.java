package make.array.strictly.increasing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author hum
 */
public class MakeArrayStrictlyIncreasing {
    Map<String, Integer> map = new HashMap<>();
    TreeSet<Integer> set = new TreeSet<>();

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        for (int i : arr2) {
            set.add(i);
        }
        int len = arr1.length;
        int result = helper(arr1, 0, -1);
        if (result == 0x3f3f3f3f) {
            return -1;
        }
        return result;
    }

    private int helper(int[] arr1, int i, int prev) {
        if (i == arr1.length) {
            return 0;
        }
        String k = String.valueOf(i) + "#" + String.valueOf(prev);
        if (map.containsKey(k)) {
            return map.get(k);
        }
        int res = 0x3f3f3f3f;
        if (arr1[i] > prev) {
            res = Math.min(res, helper(arr1, i + 1, arr1[i]));
        }
        Integer higher = set.higher(prev);
        if (higher != null) {
            res = Math.min(res, helper(arr1, i + 1, higher) + 1);
        }
        map.put(k, res);
        return res;
    }

    public int makeArrayIncreasing2(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr2) {
            set.add(i);
        }
        int len = arr1.length;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        Arrays.fill(dp[0], -0x3f3f3f3f);
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i - 1][j] < arr1[i - 1]) {
                    dp[i][j] = Math.min(dp[i][j], arr1[i - 1]);
                }
                if (j >= 1) {
                    Integer higher = set.higher(dp[i - 1][j - 1]);
                    if (higher != null) {
                        dp[i][j] = Math.min(dp[i][j], higher);
                    }
                }
            }
        }
        for (int i = 0; i <= len; i++) {
            if (dp[len][i] != 0x3f3f3f3f) {
                return i;
            }
        }
        return -1;
    }
}
