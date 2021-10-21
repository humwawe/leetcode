package count.number.of.maximum.bitwise.or.subsets;

/**
 * @author hum
 */
public class CountNumberOfMaximumBitwiseOrSubsets {
    int res = 0;
    int max = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int i : nums) {
            max |= i;
        }
        dfs(nums, 0, 0);
        return res;
    }

    void dfs(int[] nums, int i, int pre) {
        if (i == nums.length) {
            if (pre == max) {
                res++;
            }
            return;
        }
        dfs(nums, i + 1, pre | nums[i]);
        dfs(nums, i + 1, pre);
    }
}
