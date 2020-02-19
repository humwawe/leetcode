package binary.search;

import java.util.Arrays;

/**
 * @author hum
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i < 0) {
            return -1;
        }
        return i;
    }
}
