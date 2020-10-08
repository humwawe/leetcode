package special.array.with.x.elements.greater.than.or.equal.x;

import java.util.Arrays;

/**
 * @author hum
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int p = 0;
        for (int i = 0; i <= len; i++) {
            while (p < len && nums[p] < i) {
                p++;
            }
            if (i == len - p) {
                return i;
            }
        }
        return -1;
    }
}
