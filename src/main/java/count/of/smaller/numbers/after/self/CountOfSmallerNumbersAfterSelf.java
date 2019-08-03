package count.of.smaller.numbers.after.self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hum
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new LinkedList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0, right = temp.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp.get(mid) >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            result.add(0, left);
            temp.add(left, nums[i]);
        }
        return result;
    }
}
