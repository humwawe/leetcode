package minimum.moves.to.make.array.complementary;

/**
 * @author hum
 */
public class MinimumMovesToMakeArrayComplementary {
    public int minMoves(int[] nums, int limit) {
        int len = nums.length;
        int[] b = new int[limit * 2 + 1];
        for (int i = 0; i < len / 2; i++) {
            int x = Math.min(nums[i], nums[len - i - 1]);
            int y = Math.max(nums[i], nums[len - i - 1]);
            b[x + 1] += 1;
            b[x + y] -= 1;
            b[x + y + 1] += 1;
            b[limit + y + 1] -= 1;
            b[2] += 2;
            b[x + 1] -= 2;
            b[limit + y + 1] += 2;
            b[2 * limit + 1] -= 2;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 2; i <= 2 * limit; i++) {
            b[i] += b[i - 1];
            res = Math.min(res, b[i]);
        }
        return res;
    }
}
