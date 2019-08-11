package count.of.range.sum;

import java.util.TreeMap;

/**
 * @author hum
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        long[] sum = new long[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        int result = 0;
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (sum[i] >= lower && sum[i] <= upper) {
                result++;
            }
            for (Integer count : treeMap.subMap(sum[i] - upper, true, sum[i] - lower, true).values()) {
                result += count;
            }
            if (treeMap.containsKey(sum[i])) {
                Integer count = treeMap.get(sum[i]);
                treeMap.put(sum[i], count + 1);
            } else {
                treeMap.put(sum[i], 1);
            }

        }

        return result;
    }
}
