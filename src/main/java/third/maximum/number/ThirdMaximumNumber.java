package third.maximum.number;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hum
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            if (queue.contains(num)) {
                continue;
            }
            if (queue.size() < 3) {
                queue.add(num);
            } else {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        return queue.size() == 3 ? queue.peek() : max;
    }


}
