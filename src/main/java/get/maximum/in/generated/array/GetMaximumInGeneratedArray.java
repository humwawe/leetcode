package get.maximum.in.generated.array;

/**
 * @author hum
 */
public class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n > 0) {
            int ans = 1;
            int[] nums = new int[n + 1];
            nums[1] = 1;
            for (int i = 2; i <= n; i++) {
                if (i % 2 == 0) {
                    nums[i] = nums[i / 2];
                } else {
                    nums[i] = nums[i / 2] + nums[i / 2 + 1];
                }
                ans = Math.max(ans, nums[i]);
            }
            return ans;
        }
        return 0;
    }
}
