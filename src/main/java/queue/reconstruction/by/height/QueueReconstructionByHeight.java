package queue.reconstruction.by.height;

import java.util.*;

/**
 * @author hum
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int[] person : people) {
            int h = person[0];
            int k = person[1];
            set.add(k);
            if (map.containsKey(k)) {
                map.get(k).add(h);
            } else {
                Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
                queue.add(h);
                map.put(k, queue);
            }
        }

        for (Integer k : set) {
            Queue<Integer> queue = map.get(k);
            while (!queue.isEmpty()) {
                int count = 0;
                int index = 0;
                Integer poll = queue.poll();
                for (int[] res : result) {
                    if (count == k) {
                        break;
                    }
                    index++;
                    if (res[0] >= poll) {
                        count++;
                    }

                }
                result.add(index, new int[]{poll, k});
            }
        }
        return result.toArray(new int[0][]);
    }

}
