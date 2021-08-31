package find.the.kth.largest.integer.in.the.array;

import java.util.Arrays;

/**
 * @author hum
 */
public class FindTheKthLargestIntegerInTheArray {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (x, y) -> {
            int len1 = x.length();
            int len2 = y.length();
            if (len1 != len2) {
                return len2 - len1;
            } else {
                return y.compareTo(x);
            }
        });
        return nums[k - 1];
    }
}
