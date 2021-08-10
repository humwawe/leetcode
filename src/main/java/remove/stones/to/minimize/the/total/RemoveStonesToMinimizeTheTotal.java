package remove.stones.to.minimize.the.total;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
        int sum = 0;
        for (int pile : piles) {
            priorityQueue.add(pile);
            sum += pile;
        }
        int remove = 0;
        for (int i = 0; i < k; i++) {
            Integer poll = priorityQueue.poll();
            remove += poll / 2;
            priorityQueue.add(poll - poll / 2);
        }
        return sum - remove;
    }
}
