package reduction.operations.to.make.the.array.elements.equal;

import java.util.Arrays;

/**
 * @author hum
 */
public class ReductionOperationsToMakeTheArrayElementsEqual {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int cnt = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i - 1]) {
                cnt++;
            }
            res += cnt;
        }
        return res;
    }
}
