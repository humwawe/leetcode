package process.restricted.friend.requests;

/**
 * @author hum
 */
public class ProcessRestrictedFriendRequests {
    int N = 1005;
    int[] p = new int[N];

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int len = requests.length;
        boolean[] res = new boolean[len];
        f:
        for (int i = 0; i < len; i++) {
            int[] request = requests[i];
            int x = request[0];
            int y = request[1];
            for (int[] restriction : restrictions) {
                if ((find(x) == find(restriction[0]) && find(y) == find(restriction[1])) || (find(x) == find(restriction[1]) && find(y) == find(restriction[0]))) {
                    res[i] = false;
                    continue f;
                }
            }
            res[i] = true;
            union(x, y);
        }
        return res;
    }

    void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }
        p[find(a)] = find(b);
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
