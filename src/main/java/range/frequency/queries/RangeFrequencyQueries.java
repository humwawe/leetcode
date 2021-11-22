package range.frequency.queries;

import java.util.*;

/**
 * @author hum
 */
public class RangeFrequencyQueries {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public RangeFrequencyQueries(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(i);
        }

    }

    public int query(int left, int right, int value) {
        List<Integer> list = map.get(value);
        if (list == null) {
            return 0;
        }
        int i = upperBoundList(list, right);
        int j = lowerBoundList(list, left);
        return i - j;
    }

    int lowerBoundList(List<Integer> list, int t) {
        int result = Collections.binarySearch(list, t, (o1, o2) -> (o1.compareTo(o2) >= 0) ? 1 : -1);
        return (result >= 0) ? result : ~result;
    }

    int upperBoundList(List<Integer> list, int t) {
        int result = Collections.binarySearch(list, t, (o1, o2) -> (o1.compareTo(o2) > 0) ? 1 : -1);
        return (result >= 0) ? result : ~result;
    }
}
