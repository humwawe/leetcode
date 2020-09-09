package shortest.subarray.to.be.removed.to.make.array.sorted;

/**
 * @author hum
 */
public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int left = 0;
        while (left + 1 < len && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == len - 1) {
            return 0;
        }
        int right = len - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        int result = Math.min(len - left - 1, right);
        int i = 0, j = right;
        while (i <= left && j <= len - 1) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
