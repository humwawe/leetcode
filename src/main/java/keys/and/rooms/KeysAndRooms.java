package keys.and.rooms;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        boolean[] vis = new boolean[len];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(rooms.get(0));
        vis[0] = true;
        for (Integer integer : rooms.get(0)) {
            vis[integer] = true;
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> list = rooms.get(poll);
            for (Integer integer : list) {
                if (!vis[integer]) {
                    queue.add(integer);
                    vis[integer] = true;
                }
            }
        }
        for (boolean f : vis) {
            if (!f) {
                return false;
            }
        }
        return true;
    }
}
