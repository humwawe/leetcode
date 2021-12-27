package recover.the.original.array;

import java.util.Arrays;

/**
 * @author hum
 */
public class RecoverTheOriginalArray {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int k2 = nums[i] - nums[0];
            if (k2 == 0 || k2 % 2 == 1) {
                continue;
            }
            int[] ans = new int[n / 2];
            int t = 0;
            boolean[] vis = new boolean[n];
            int left = 0;
            int right = i;
            for (int j = 0; j < n / 2; j++) {
                while (left < n && vis[left]) {
                    left++;
                }
                while (right < n && nums[right] - nums[left] != k2) {
                    right++;
                }
                if (right == n) {
                    break;
                }
                vis[right] = true;
                ans[t++] = nums[left] + k2 / 2;
                left++;
                right++;
            }
            if (t == n / 2) {
                return ans;
            }
        }
        return new int[]{};
    }

}
