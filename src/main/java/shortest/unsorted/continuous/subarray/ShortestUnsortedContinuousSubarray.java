package shortest.unsorted.continuous.subarray;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(nums);
        int start = -1, end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != nums[i]) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            return 0;
        }
        for (int j = arr.length - 1; j >= start; j--) {
            if (arr[j] != nums[j]) {
                end = j;
                break;
            }
        }
        return end - start + 1;
    }
}
