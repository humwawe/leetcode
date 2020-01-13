package open.the.lock;

import java.util.*;

/**
 * @author hum
 */
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        Set<String> vis = new HashSet<>();

        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        vis.add("0000");
        int result = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (node.equals(target)) {
                    return result;
                }
                if (!set.contains(node)) {
                    for (int j = 0; j < 4; ++j) {
                        for (int d = -1; d <= 1; d += 2) {
                            int y = ((node.charAt(j) - '0') + d + 10) % 10;
                            String next = node.substring(0, j) + ("" + y) + node.substring(j + 1);
                            if (!vis.contains(next)) {
                                vis.add(next);
                                queue.add(next);
                            }
                        }
                    }
                }
            }

        }
        return -1;
    }
}
