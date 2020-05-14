package distant.barcodes;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : barcodes) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());
        int[] result = new int[barcodes.length];
        int index = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            result[index++] = a;
            result[index++] = b;
            if (map.get(a) > 1) {
                map.put(a, map.get(a) - 1);
                queue.add(a);
            }
            if (map.get(b) > 1) {
                map.put(b, map.get(b) - 1);
                queue.add(b);
            }
        }
        if (!queue.isEmpty()) {
            result[index] = queue.poll();
        }
        return result;
    }
}
