package dice.roll.simulation;


/**
 * @author hum
 */
public class DiceRollSimulation {
    int[] r;
    int n;
    int mod = (int) (1e9 + 7);
    Long[][][] memo;

    public int dieSimulator(int n, int[] rollMax) {
        memo = new Long[n][7][16];
        r = new int[rollMax.length + 1];
        System.arraycopy(rollMax, 0, r, 0, rollMax.length);
        r[rollMax.length] = 10;
        this.n = n;
        return (int) (helper(0, 6, 1) % mod);
    }

    private long helper(int i, int prev, int count) {
        if (r[prev] < count) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i][prev][count] != null) {
            return memo[i][prev][count];
        }
        long res = 0;
        for (int j = 0; j < 6; j++) {
            res += helper(i + 1, j, prev == j ? count + 1 : 1);
            res = res % mod;
        }
        return memo[i][prev][count] = res;
    }
}
