package kth.largest.element.in.an.array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hum
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minQueue.size() < k) {
                minQueue.offer(num);
            } else if (minQueue.size() == k && num > minQueue.peek()) {
                minQueue.poll();
                minQueue.offer(num);
            }
        }
        return minQueue.peek();
    }
}
