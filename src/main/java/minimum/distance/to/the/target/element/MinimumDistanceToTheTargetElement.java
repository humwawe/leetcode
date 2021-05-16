package minimum.distance.to.the.target.element;

/**
 * @author hum
 */
public class MinimumDistanceToTheTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        int len = nums.length;
        int res = (int) 1e5;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                res = Math.min(res, Math.abs(i - start));
            }
        }
        return res;
    }
}
