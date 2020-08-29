package most.visited.sector.in.a.circular.track;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class MostVisitedSectorInACircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int len = rounds.length;
        int left = rounds[0];
        int right = rounds[len - 1];
        if (right < left) {
            for (int i = 1; i <= right; i++) {
                res.add(i);
            }
            for (int i = left; i <= n; i++) {
                res.add(i);
            }
        } else {
            for (int i = left; i <= right; i++) {
                res.add(i);
            }
        }
        return res;
    }
}
