package minimum.swaps.to.group.all.one.together.II;

/**
 * @author hum
 */
public class MinimumSwapsToGroupAllOnesTogetherIi {
    public int minSwaps(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for (int num : nums) {
            cnt += num;
        }

        int[] sum = new int[len * 2 + 1];
        for (int i = 0; i < 2 * len; i++) {
            sum[i + 1] = sum[i] + nums[i % len];
        }

        int res = (int) 1e8;
        for (int i = 0; i < 2 * len; i++) {
            int j = i + cnt;
            if (j > 2 * len) {
                break;
            }
            res = Math.min(res, cnt - (sum[j] - sum[i]));
        }
        return res;
    }
}
