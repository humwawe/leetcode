package check.all.ones.are.at.least.length.k.places.away;

/**
 * @author hum
 */
public class CheckIfAll1sAreAtLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int s = -k - 5;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                if (i - s < k) {
                    return false;
                }
                s = i;
            }
        }
        return true;
    }
}
