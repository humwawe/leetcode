package decrease.elements.to.make.array.zigzag;

/**
 * @author hum
 */
public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int result = 0;
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        for (int i = 0; i < len; i += 2) {
            if (i == 0) {
                if (nums[i] >= nums[i + 1]) {
                    result += nums[i] - nums[i + 1] + 1;
                }
            } else if (i == len - 1) {
                if (nums[i] >= nums[i - 1]) {
                    result += nums[i] - nums[i - 1] + 1;
                }
            } else {
                int min = Math.min(nums[i - 1], nums[i + 1]);
                if (nums[i] >= min) {
                    result += nums[i] - min + 1;
                }
            }
        }
        int result1 = 0;
        for (int i = 1; i < len; i += 2) {
            if (i == len - 1) {
                if (nums[i] >= nums[i - 1]) {
                    result1 += nums[i] - nums[i - 1] + 1;
                }
            } else {
                int min = Math.min(nums[i - 1], nums[i + 1]);
                if (nums[i] >= min) {
                    result1 += nums[i] - min + 1;
                }
            }
        }
        return Math.min(result, result1);
    }
}
