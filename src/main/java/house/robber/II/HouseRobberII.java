package house.robber.II;

/**
 * @author hum
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] result1 = new int[nums.length];
        int[] result2 = new int[nums.length];

        result1[0] = nums[0];
        result1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            result1[i] = Math.max(result1[i - 1], result1[i - 2] + nums[i]);
        }
        result2[0] = 0;
        result2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            result2[i] = Math.max(result2[i - 1], result2[i - 2] + nums[i]);
        }

        return Math.max(result1[nums.length - 2], result2[nums.length - 1]);
    }

}
