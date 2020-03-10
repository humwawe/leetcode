package sup.egg.drop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class SuperEggDrop {
    Map<Integer, Integer> memos = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dfs(k, n);
    }

    int dfs(int k, int n) {
        if (memos.containsKey(n * 100 + k)) {
            return memos.get(n * 100 + k);
        }
        int ans;
        if (n == 0) {
            ans = 0;
        } else if (k == 1) {
            ans = n;
        } else {
            int low = 1, high = n;
            while (low + 1 < high) {
                int mid = (low + high) / 2;
                int broken = dfs(k - 1, mid - 1);
                int alive = dfs(k, n - mid);
                if (broken < alive) {
                    low = mid;
                } else if (broken > alive) {
                    high = mid;
                } else {
                    low = high = mid;
                }
            }
            ans = 1 + Math.min(Math.max(dfs(k - 1, low - 1), dfs(k, n - low)), Math.max(dfs(k - 1, high - 1), dfs(k, n - high)));
        }
        memos.put(n * 100 + k, ans);
        return memos.get(n * 100 + k);
    }
}
