package intervals.between.identical.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class IntervalsBetweenIdenticalElements {
    public long[] getDistances(int[] arr) {
        int len = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        long[] res = new long[len];
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            long sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            long tmp = 0;
            for (int i = 0; i < list.size(); i++) {
                int idx = list.get(i);
                tmp += idx;
                res[idx] = sum - 2 * tmp + (long) (i + 1) * idx - (long) (list.size() - 1 - i) * idx;
            }
        }
        return res;
    }
}
