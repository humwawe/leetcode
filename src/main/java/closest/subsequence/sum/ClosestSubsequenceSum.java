package closest.subsequence.sum;

import java.util.TreeSet;

/**
 * @author hum
 */
public class ClosestSubsequenceSum {
    TreeSet<Integer> set = new TreeSet<>();
    int len;
    int[] nums;
    int res;
    int goal;

    public int minAbsDifference(int[] nums, int goal) {
        this.nums = nums;
        this.goal = goal;
        res = Math.abs(goal);
        len = nums.length;
        helper(0, 0);
        helper2(len / 2, 0);
        return res;
    }

    private void helper2(int i, int sum) {
        if (i == len) {
            int t = goal - sum;
            Integer ceiling = set.ceiling(t);
            if (ceiling != null) {
                res = Math.min(res, ceiling - t);
            }
            Integer floor = set.floor(t);
            if (floor != null) {
                res = Math.min(res, t - floor);
            }
            return;
        }
        helper2(i + 1, sum);
        helper2(i + 1, sum + nums[i]);
    }

    private void helper(int i, int sum) {
        if (i == len / 2) {
            set.add(sum);
            return;
        }
        helper(i + 1, sum);
        helper(i + 1, sum + nums[i]);
    }
}
