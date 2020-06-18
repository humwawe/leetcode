package jump.game.IV;

import java.util.*;

/**
 * @author hum
 */
public class JumpGameIV {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        boolean[] vis = new boolean[len];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        vis[0] = true;
        int result = 0;
        Set<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                if (poll == len - 1) {
                    return result;
                }
                if (poll + 1 < len && !vis[poll + 1]) {
                    queue.add(poll + 1);
                    vis[poll + 1] = true;
                }
                if (poll - 1 >= 0 && !vis[poll - 1]) {
                    queue.add(poll - 1);
                    vis[poll + 1] = true;
                }
                if (seen.contains(arr[poll])) {
                    continue;
                }
                List<Integer> list = map.get(arr[poll]);
                for (Integer integer : list) {
                    if (vis[integer]) {
                        continue;
                    }
                    queue.add(integer);
                    vis[integer] = true;
                }
                seen.add(arr[poll]);
            }
        }
        return -1;
    }
}
