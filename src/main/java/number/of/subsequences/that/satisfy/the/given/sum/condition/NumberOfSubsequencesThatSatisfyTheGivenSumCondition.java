package number.of.subsequences.that.satisfy.the.given.sum.condition;

import java.util.Arrays;

/**
 * @author hum
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    int mod = (int) (1e9 + 7);

    public int numSubseq(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        return helper(nums, 0, len - 1, target);
    }

    private int helper(int[] nums, int i, int j, int target) {
        int res = 0;
        while (i <= j && nums[i] + nums[j] > target) {
            j--;
        }
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        res += qp(2, j - i - 1, mod) + helper(nums, i + 1, j, target) + helper(nums, i, j - 1, target);
        return res;
    }

    int qp(int m, int k, int p) {
        long res = 1 % p, t = m;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * t % p;
            }
            t = t * t % p;
            k >>= 1;
        }
        return (int) res % p;
    }
}
