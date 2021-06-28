package remove.one.element.to.make.the.array.strictly.increasing;

/**
 * @author hum
 */
public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {
    public boolean canBeIncreasing(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    nums[i] = nums[i - 1];
                }
                cnt++;
                if (cnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
