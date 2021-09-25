package find.original.array.from.doubled.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[]{};
        }
        Arrays.sort(changed);

        int[] res = new int[changed.length / 2];
        int idx = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i : changed) {
            if (!queue.isEmpty() && queue.peek() * 2 == i) {
                res[idx++] = queue.poll();
            } else {
                queue.add(i);
            }
        }

        if (!queue.isEmpty()) {
            return new int[]{};
        }
        return res;
    }
}
