package reduce.array.size.to.the.half;

import java.util.*;

/**
 * @author hum
 */
public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (a, b) -> b - a);
        int result = 0;
        int count = 0;
        while (count * 2 < len) {
            count += list.get(result++);
        }
        return result;
    }
}
