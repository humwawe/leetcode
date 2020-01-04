package find.pivot.index;

/**
 * @author hum
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (res * 2 == sum - nums[i]) {
                return i;
            }
            res += nums[i];
        }
        return -1;
    }
}
