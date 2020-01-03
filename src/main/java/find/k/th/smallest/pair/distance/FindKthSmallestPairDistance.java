package find.k.th.smallest.pair.distance;

/**
 * @author hum
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        int[] bucket = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                bucket[Math.abs(nums[i] - nums[j])]++;
            }
        }
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            count += bucket[i];
            if (count >= k) {
                return i;
            }
        }
        return -1;
    }
}
