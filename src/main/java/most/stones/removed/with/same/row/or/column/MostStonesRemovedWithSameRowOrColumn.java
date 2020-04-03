package most.stones.removed.with.same.row.or.column;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class MostStonesRemovedWithSameRowOrColumn {
    int[] p = new int[10000];

    public int removeStones(int[][] stones) {
        for (int i = 0; i < 10000; i++) {
            p[i] = i;
        }
        for (int[] stone : stones) {
            p[find(stone[0])] = find(stone[1] + +10000);
        }

        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(find(stone[0]));
        }
        return stones.length - set.size();
    }

    private int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
