package sum.of.mutated.array.closest.to.target;

import java.util.Arrays;

/**
 * @author hum
 */
public class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int l = 0;
        int r = arr[len - 1];
        while (l < r) {
            int mid = (l + r + 1) / 2;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += Math.min(mid, arr[i]);
            }
            if (sum <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.min(l, arr[i]);
        }
        int res1 = Math.abs(sum - target);
        sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.min(l + 1, arr[i]);
        }
        int res2 = Math.abs(sum - target);
        if (res1 <= res2) {
            return l;
        } else {
            return l + 1;
        }
    }
}
