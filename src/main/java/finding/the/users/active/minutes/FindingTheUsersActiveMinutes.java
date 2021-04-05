package finding.the.users.active.minutes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class FindingTheUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0];
            int m = log[1];
            if (map.containsKey(id)) {
                map.get(id).add(m);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(m);
                map.put(id, set);
            }
        }
        int[] res = new int[k];
        for (Integer key : map.keySet()) {
            int v = map.get(key).size();
            res[v - 1]++;
        }
        return res;
    }
}
