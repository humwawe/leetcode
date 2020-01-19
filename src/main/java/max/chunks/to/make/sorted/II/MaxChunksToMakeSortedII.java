package max.chunks.to.make.sorted.II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] clone = arr.clone();
        Arrays.sort(clone);
        for (int i = clone.length - 1; i >= 0; i--) {
            map.put(clone[i], i);
        }
        int end = 0;
        int result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            end = Math.max(end, map.get(arr[i]) + count.getOrDefault(arr[i], 0));
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
            if (i >= end) {
                result++;
            }
        }
        return result;
    }
}
