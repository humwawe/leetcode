package lexicographical.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(String.valueOf(i));
        }
        while (!queue.isEmpty()) {
            result.add(Integer.valueOf(queue.poll()));
        }
        return result;
    }


}
