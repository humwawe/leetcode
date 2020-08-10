package kth.missing.positive.number;

/**
 * @author hum
 */
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int len = arr.length;
        int idx = 0;
        int cur = 1;
        while (k > 0) {
            if (idx < len && arr[idx] == cur) {
                idx++;
            } else {
                k--;
            }
            cur++;
        }
        return cur - 1;
    }
}
