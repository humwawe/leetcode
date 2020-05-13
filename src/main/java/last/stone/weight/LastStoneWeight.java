package last.stone.weight;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a == b) {
                continue;
            }
            queue.add(Math.abs(a - b));
        }
        if (queue.isEmpty()) {
            return 0;
        }
        return queue.poll();
    }
}
