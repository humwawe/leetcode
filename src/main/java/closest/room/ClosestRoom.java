package closest.room;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author hum
 */
public class ClosestRoom {

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int len = queries.length;
        int[] res = new int[len];
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (x, y) -> queries[y][1] - queries[x][1]);
        Arrays.sort(rooms, (x, y) -> y[1] - x[1]);
        TreeSet<Integer> treeSet = new TreeSet<>();
        int j = 0;
        for (int i = 0; i < len; i++) {
            int index = idx[i];
            int lim = queries[index][1];
            while (j < rooms.length) {
                if (rooms[j][1] >= lim) {
                    treeSet.add(rooms[j][0]);
                    j++;
                } else {
                    break;
                }
            }
            int id = queries[index][0];
            int tmp = -1;
            Integer floor = treeSet.floor(id);
            if (floor != null) {
                tmp = floor;
            }
            Integer ceiling = treeSet.ceiling(id);
            if (ceiling != null) {
                if (floor == null || ceiling - id < id - floor) {
                    tmp = ceiling;
                }
            }
            res[index] = tmp;
        }
        return res;
    }
}
