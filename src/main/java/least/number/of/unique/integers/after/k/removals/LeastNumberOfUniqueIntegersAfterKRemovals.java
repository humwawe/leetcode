package least.number.of.unique.integers.after.k.removals;

import java.util.*;

/**
 * @author hum
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int result = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (k >= list.get(i)) {
                k -= list.get(i);
                result--;
            } else {
                break;
            }
        }
        return result;
    }
}
