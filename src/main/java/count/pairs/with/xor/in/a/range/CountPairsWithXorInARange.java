package count.pairs.with.xor.in.a.range;

/**
 * @author hum
 */
public class CountPairsWithXorInARange {
    public int countPairs(int[] nums, int low, int high) {
        int res = 0;
        for (int num : nums) {
            res += query(num, high + 1) - query(num, low);
            insert(num);
        }
        return res;
    }

    int n = 20005;
    int[][] son = new int[2][n * 21];
    int[] cnt = new int[n];
    int idx = 0;

    void insert(int num) {
        int p = 0;
        for (int i = 20; i >= 0; i--) {
            int u = (num >> i) & 1;
            if (son[u][p] == 0) {
                son[u][p] = ++idx;
            }
            p = son[u][p];
            cnt[p]++;
        }
    }

    int query(int num, int max) {
        int res = 0;
        int p = 0;
        for (int i = 20; i >= 0; i--) {
            int u = (num >> i) & 1;
            int v = (max >> i) & 1;
            if (v == 1) {
                res += cnt[son[u][p]];
                p = son[1 - u][p];
            } else {
                p = son[u][p];
            }
            if (p == 0) {
                return res;
            }
        }
        return res;
    }
}
