package construct.the.lexicographically.largest.valid.sequence;

/**
 * @author hum
 */
public class ConstructTheLexicographicallyLargestValidSequence {
    int[] res;
    int n;
    boolean[] vis;

    public int[] constructDistancedSequence(int n) {
        this.n = n;
        res = new int[2 * n - 1];
        vis = new boolean[n + 1];
        dfs(0);
        return res;
    }

    private boolean dfs(int pos) {
        if (pos == 2 * n - 1) {
            return true;
        }
        if (res[pos] == 0) {
            for (int i = n; i >= 1; i--) {
                if (vis[i]) {
                    continue;
                }
                if (i != 1 && (pos + i >= 2 * n - 1 || res[pos + i] != 0)) {
                    continue;
                }
                vis[i] = true;
                if (i == 1) {
                    res[pos] = i;
                } else {
                    res[pos] = i;
                    res[pos + i] = i;
                }
                if (dfs(pos + 1)) {
                    return true;
                }
                vis[i] = false;
                res[pos] = 0;
                if (i != 1) {
                    res[pos + i] = 0;
                }
            }
        }
        if (res[pos] == 0) {
            return false;
        }
        return dfs(pos + 1);
    }
}
