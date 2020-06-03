package make.array.strictly.increasing;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author hum
 */
public class MakeArrayStrictlyIncreasing {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr2) {
            set.add(i);
        }
        int len = arr1.length;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        dp[0][0] = -0x3f3f3f3f;
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
