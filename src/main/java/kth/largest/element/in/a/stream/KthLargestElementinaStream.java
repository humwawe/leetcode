package kth.largest.element.in.a.stream;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class KthLargestElementinaStream {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public KthLargestElementinaStream(int k, int[] nums) {
        priorityQueue.add(Integer.MIN_VALUE);
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
    }

    public int add(int val) {
        if (priorityQueue.peek() < val) {
            priorityQueue.add(val);
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
