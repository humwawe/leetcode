package range.sum.of.sorted.subarray.sums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class RangeSumOfSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        int sum = 0;
        int mod = (int) (1e9 + 7);
        for (int i = left - 1; i < right; i++) {
            sum += list.get(i);
            sum %= mod;
        }
        return sum;
    }
}
