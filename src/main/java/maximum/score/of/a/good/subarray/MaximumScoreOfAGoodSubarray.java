package maximum.score.of.a.good.subarray;

/**
 * @author hum
 */
public class MaximumScoreOfAGoodSubarray {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int l = k;
        int r = k;
        int res = 0;
        for (int val = nums[k]; val > 0; --val) {
            while (l - 1 >= 0 && nums[l - 1] >= val) {
                --l;
            }
            while (r + 1 < n && nums[r + 1] >= val) {
                ++r;
            }
            res = Math.max(res, val * (r - l + 1));
        }
        return res;
    }
}
