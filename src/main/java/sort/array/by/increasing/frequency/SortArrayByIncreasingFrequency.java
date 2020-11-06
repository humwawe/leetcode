package sort.array.by.increasing.frequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int len = nums.length;
        Integer[] tmp = new Integer[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp, (x, y) -> {
            int t = map.get(x) - map.get(y);
            if (t == 0) {
                return y - x;
            } else {
                return t;
            }
        });
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = tmp[i];
        }
        return res;
    }
}
