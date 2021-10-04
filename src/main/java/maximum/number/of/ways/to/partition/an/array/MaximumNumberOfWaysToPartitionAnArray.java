package maximum.number.of.ways.to.partition.an.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MaximumNumberOfWaysToPartitionAnArray {
    public int waysToPartition(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = nums[len - 1];
        int t = 0;
        for (int i = 0; i < len - 1; i++) {
            t += nums[i];
            map.put(t, map.getOrDefault(t, 0) + 1);
            sum += nums[i];
        }
        int res = 0;
        if (sum % 2 == 0) {
            res = map.getOrDefault(sum / 2, 0);
        }

        Map<Integer, Integer> map1 = new HashMap<>();

        t = 0;
        for (int i = 0; i < len; i++) {
            int d = k - nums[i];
            if ((sum + d) % 2 == 0) {
                int tmp = (sum + d) / 2;
                res = Math.max(res, map1.getOrDefault(tmp, 0) + map.getOrDefault(tmp - d, 0));
            }

            t += nums[i];
            map.put(t, map.getOrDefault(t, 1) - 1);
            if (map.get(t) == 0) {
                map.remove(t);
            }
            map1.put(t, map1.getOrDefault(t, 0) + 1);
        }

        return res;
    }
}
