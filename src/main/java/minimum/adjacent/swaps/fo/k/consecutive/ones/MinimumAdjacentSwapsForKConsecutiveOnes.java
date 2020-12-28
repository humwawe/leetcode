package minimum.adjacent.swaps.fo.k.consecutive.ones;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class MinimumAdjacentSwapsForKConsecutiveOnes {
    public int minMoves(int[] nums, int k) {
        int len = nums.length;
        List<Long> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                list.add((long) (i - list.size()));
            }
        }

        long[] sum = new long[list.size() + 1];
        for (int i = 1; i <= list.size(); i++) {
            sum[i] = sum[i - 1] + list.get(i - 1);
        }
        long res = Long.MAX_VALUE;
        for (int i = k; i <= list.size(); i++) {
            int l = i - k + 1, r = i;
            int mid = (l + r) / 2;
            long x = list.get(mid - 1);
            long left = x * (mid - l) - (sum[mid - 1] - sum[l - 1]);
            long right = (sum[r] - sum[mid]) - x * (r - mid);
            res = Math.min(res, left + right);
        }
        return (int) res;
    }

}
