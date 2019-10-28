package matchsticks.to.square;


import java.util.Arrays;

/**
 * @author hum
 */
public class MatchsticksToSquare {
    int count = 0;

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        long target = sum / 4;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return helper(nums, 0, target, 0, 0, 0, 0);
    }

    private boolean helper(int[] nums, int start, long t, int l1, int l2, int l3, int l4) {
        if (start == nums.length) {
            return l1 == l2 && l2 == l3 && l3 == l4 && l4 == t;
        }
        if (l1 > t || l2 > t || l3 > t || l4 > t) {
            return false;
        }
        return helper(nums, start + 1, t, l1 + nums[start], l2, l3, l4) ||
                helper(nums, start + 1, t, l1, l2 + nums[start], l3, l4) ||
                helper(nums, start + 1, t, l1, l2, l3 + nums[start], l4) ||
                helper(nums, start + 1, t, l1, l2, l3, l4 + nums[start]);
    }
}
