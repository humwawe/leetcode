package minimum.number.of.removals.to.make.mountain.array;

/**
 * @author hum
 */
public class MinimumNumberOfRemovalstoMakeMountainArray {
    public int minimumMountainRemovals(int[] nums) {
        int len = nums.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        for (int i = 0; i < len; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < len - 1; i++) {
            res = Math.min(res, len - (dp1[i] + dp2[i] - 1));
        }
        return res;
    }
}
