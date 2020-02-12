package shortest.distance.to.a.character;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] result = new int[len];
        boolean[] vis = new boolean[len];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == c) {
                queue.add(i);
                vis[i] = true;
            }
        }
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                int x = poll + 1;
                int y = poll - 1;
                if (x >= 0 && x < len && !vis[x]) {
                    vis[x] = true;
                    result[x] = step;
                    queue.add(x);
                }
                if (y >= 0 && y < len && !vis[y]) {
                    vis[y] = true;
                    result[y] = step;
                    queue.add(y);
                }
            }
            step++;
        }
        return result;
    }
}
