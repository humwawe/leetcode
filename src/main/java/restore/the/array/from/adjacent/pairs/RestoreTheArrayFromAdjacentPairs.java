package restore.the.array.from.adjacent.pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            cnt.put(adjacentPair[0], cnt.getOrDefault(adjacentPair[0], 0) + 1);
            cnt.put(adjacentPair[1], cnt.getOrDefault(adjacentPair[1], 0) + 1);
            map.put(adjacentPair[0], map.getOrDefault(adjacentPair[0], 0) + adjacentPair[1]);
            map.put(adjacentPair[1], map.getOrDefault(adjacentPair[1], 0) + adjacentPair[0]);
        }
        int start = 0;
        for (Map.Entry<Integer, Integer> kv : cnt.entrySet()) {
            if (kv.getValue() == 1) {
                start = kv.getKey();
                break;
            }
        }
        int[] res = new int[adjacentPairs.length + 1];
        res[0] = start;
        int idx = 1;
        int prev = 0;
        while (idx < res.length) {
            Integer integer = map.get(start);
            if (integer == null) {
                break;
            }
            res[idx] = integer - prev;
            prev = start;
            start = res[idx];
            idx++;
        }
        return res;
    }
}
