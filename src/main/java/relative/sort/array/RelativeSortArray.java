package relative.sort.array;

import java.util.*;

/**
 * @author hum
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            list.add(i);
        }
        list.sort((a, b) -> {
            if (map.containsKey(a) && map.containsKey(b)) {
                return map.get(a) - map.get(b);
            } else if (map.containsKey(a) && !map.containsKey(b)) {
                return -1;
            } else if (!map.containsKey(a) && map.containsKey(b)) {
                return 1;
            } else {
                return a - b;
            }
        });
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
