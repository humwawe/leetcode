package find.first.and.last.position.of.element.in.sorted.array;

/**
 * @author hum
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                result[0] = helper(nums, left, mid, 0);
                result[1] = helper(nums, mid, right, 1);
                return result;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int helper(int[] nums, int left, int right, int direction) {
        int mid;
        if (direction == 0) {
            while (left < right) {
                mid = (left + right) >> 1;
                if (nums[mid] < nums[right]) {
                    left = mid + 1;
                } else if (nums[mid] == nums[right]) {
                    right = mid;
                }
            }
            return left;
        } else {
            while (left < right - 1) {
                mid = (left + right) >> 1;
                if (nums[left] < nums[mid]) {
                    right = mid - 1;
                } else if (nums[left] == nums[mid]) {
                    left = mid;
                }
            }
            if (nums[left] < nums[right]) {
                return left;
            } else {
                return right;
            }
        }
    }
}
