package beautiful.arrangement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class BeautifulArrangement {
    private int result = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int countArrangement(int n) {

        for (int i = 1; i <= n; i++) {
            List<Integer> tmp = getList(i, n);
            map.put(i, tmp);
        }
        boolean[] vis = new boolean[n + 1];
        helper(1, n, vis);
        return result;
    }

    private void helper(int i, int n, boolean[] vis) {
        if (i == n + 1) {
            result++;
            return;
        }
        List<Integer> list = map.get(i);
        for (Integer integer : list) {
            if (!vis[integer]) {
                vis[integer] = true;
                helper(i + 1, n, vis);
                vis[integer] = false;
            }
        }
    }

    private List<Integer> getList(int i, int n) {
        List<Integer> res = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            if (j % i == 0 || i % j == 0) {
                res.add(j);
            }
        }
        return res;
    }
}
