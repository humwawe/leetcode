package egg.drop.with.two.eggs.and.n.floors;

/**
 * @author hum
 */
public class EggDropWithTwoEggsAndNFloors {
    int inf = (int) 1e9;
    Integer[] memo = new Integer[1005];

    public int twoEggDrop(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        int res = inf;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(i - 1, twoEggDrop(n - i)) + 1);
        }
        return memo[n] = res;
    }
}
