package count.all.possible.routes;

/**
 * @author hum
 */
public class CountAllPossibleRoutes {
    int e;
    int[] l;
    int len;
    int mod = (int) (1e9 + 7);
    Integer[][] memo = new Integer[105][205];

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        l = locations;
        len = locations.length;
        e = finish;
        return helper(start, fuel);
    }

    private int helper(int start, int fuel) {
        long res = 0;
        if (start == e) {
            res += 1;
        }
        if (memo[start][fuel] != null) {
            return memo[start][fuel];
        }
        for (int i = 0; i < len; i++) {
            if (i == start) {
                continue;
            }
            int cost = Math.abs(l[start] - l[i]);
            if (cost <= fuel) {
                res += helper(i, fuel - cost);
            }
        }
        return memo[start][fuel] = (int) (res % mod);
    }
}
