package minimum.subsequence.in.non.increasing.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int tmp = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            tmp += nums[i];
            list.add(nums[i]);
            if (tmp > sum - tmp) {
                return list;
            }
        }
        return list;
    }
}
