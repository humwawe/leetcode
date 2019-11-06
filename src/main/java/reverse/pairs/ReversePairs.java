package reverse.pairs;

import java.util.Arrays;

/**
 * @author hum
 */
public class ReversePairs {
    int result = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        mergeSort(nums, Arrays.copyOf(nums, n), 0, n - 1);
        return result;
    }

    private void mergeSort(int[] nums, int[] tmps, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) >> 1;
        mergeSort(tmps, nums, lo, mid);
        mergeSort(tmps, nums, mid + 1, hi);
        int i = lo, j = mid + 1;
        while (i <= mid && j <= hi) {
            if (tmps[i] > 2L * tmps[j]) {
                result += mid - i + 1;
                ++j;
            } else {
                ++i;
            }
        }
        merge(nums, tmps, lo, hi);
    }

    private void merge(int[] nums, int[] tmps, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) >> 1;
        int i = lo, j = mid + 1, pos = lo;
        while (i <= mid && j <= hi) {
            nums[pos++] = tmps[i] < tmps[j] ? tmps[i++] : tmps[j++];
        }
        while (i <= mid) {
            nums[pos++] = tmps[i++];
        }
        while (j <= hi) {
            nums[pos++] = tmps[j++];
        }
    }
}
