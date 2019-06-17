package house.robber;

/**
 * @author hum
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int[][] result = new int[nums.length + 1][2];

        for (int i = 0; i < nums.length; i++) {
            result[i + 1][0] = Math.max(result[i][0], result[i][1]);
            result[i + 1][1] = result[i][0] + nums[i];
        }
        return Math.max(result[nums.length][0], result[nums.length][1]);
    }
}
