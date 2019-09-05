package largest.divisible.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }
        Nod[] dp = new Nod[len + 1];
        for (int i = 0; i <= len; i++) {
            dp[i] = new Nod();
        }
        dp[0].parent = -1;
        dp[0].size = 0;
        Arrays.sort(nums);
        int maxSize = 0;
        int index = 0;
        for (int i = 0; i < len; i++) {
            dp[i + 1].parent = -1;
            dp[i + 1].size = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j + 1].size >= dp[i + 1].size) {
                        dp[i + 1].parent = j;
                        dp[i + 1].size = dp[j + 1].size + 1;
                        if (dp[i + 1].size > maxSize) {
                            maxSize = dp[i + 1].size;
                            index = i;
                        }
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (dp[index + 1].size != 0) {
            result.add(0, nums[index]);
            index = dp[index + 1].parent;
        }
        return result;

    }

    class Nod {
        private int parent;
        private int size;
    }
}
