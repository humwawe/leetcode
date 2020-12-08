package construct.target.array.with.multiple.sums;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        if (target.length == 1 && target[0] > 1) {
            return false;
        }
        long sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            queue.add(target[i]);
        }
        while (sum > target.length) {
            int poll = queue.poll();
            long other = sum - poll;
            if (other == 1) {
                return true;
            }
            long cnt = poll / other;
            poll %= other;
            if (cnt == 0) {
                poll -= other;
            }
            if (poll < 1) {
                return false;
            }
            sum -= other * cnt;
            queue.add(poll);
        }
        return true;
    }
}
