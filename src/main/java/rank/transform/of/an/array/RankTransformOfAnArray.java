package rank.transform.of.an.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author hum
 */
public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int i : set) {
            if (map.containsKey(i)) {
                continue;
            }
            map.put(i, idx++);
        }
        int len = arr.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}
