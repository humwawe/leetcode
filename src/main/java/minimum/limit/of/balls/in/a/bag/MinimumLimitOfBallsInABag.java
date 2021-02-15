package minimum.limit.of.balls.in.a.bag;

/**
 * @author hum
 */
public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = (int) 1e9;
        while (l < r) {
            int mid = l + r >> 1;
            long tmp = 0;
            for (int num : nums) {
                if (num <= mid) {
                    continue;
                }
                tmp += (num - 1) / mid;
            }
            if (tmp <= maxOperations) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
