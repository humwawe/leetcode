package maximum.product.after.k.increments;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MaximumProductAfterKIncrements {
  public int maximumProduct(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int num : nums) {
      priorityQueue.add(num);
    }
    for (int i = 0; i < k; i++) {
      Integer poll = priorityQueue.poll();
      priorityQueue.add(poll + 1);
    }
    long res = 1;
    int mod = (int) (1e9 + 7);
    while (!priorityQueue.isEmpty()) {
      res = (res * priorityQueue.poll()) % mod;
    }
    return (int) res;
  }
}
