package find.the.middle.index.in.array;

import java.util.Arrays;

/**
 * @author hum
 */
public class FindTheMiddleIndexInArray {
    public int findMiddleIndex(int[] nums) {
        int all = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (all - sum - nums[i] == sum) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
