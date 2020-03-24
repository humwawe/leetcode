package binary.subarrays.with.sum;

/**
 * @author hum
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] a, int s) {
        int res = 0;
        int[] map = new int[a.length + 1];
        map[0] = 1;
        int sum = 0;
        for (int e : a) {
            sum += e;
            if (sum >= s) {
                res += map[sum - s];
            }
            map[sum]++;
        }

        return res;
    }
}
