package partition.array.according.to.given.pivot;

/**
 * @author hum
 */
public class PartitionArrayAccordingToGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int idx = 0;
        for (int i : nums) {
            if (i < pivot) {
                res[idx++] = i;
            }
        }
        for (int i : nums) {
            if (i == pivot) {
                res[idx++] = i;
            }
        }
        for (int i : nums) {
            if (i > pivot) {
                res[idx++] = i;
            }
        }
        return res;
    }
}
