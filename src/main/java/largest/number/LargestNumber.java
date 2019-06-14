package largest.number;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hum
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "0";
        }
        Comparator<String> cmp = (o1, o2) -> (o2 + o1).compareTo(o1 + o2);
        StringBuilder result = new StringBuilder();
        Queue<String> queue = new PriorityQueue<>(cmp);
        for (int num : nums) {
            queue.add(String.valueOf(num));
        }
        if ("0".equals(queue.peek())) {
            return "0";
        }
        while (!queue.isEmpty()) {
            result.append(queue.poll());
        }
        return result.toString();
    }

}
