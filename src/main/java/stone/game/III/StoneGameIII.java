package stone.game.III;

/**
 * @author hum
 */
public class StoneGameIII {
    int inf = (int) 1e8;
    Integer[] memo = new Integer[50005];

    public String stoneGameIII(int[] stoneValue) {
        int t = helper(stoneValue, 0);
        if (t == 0) {
            return "Tie";
        } else if (t > 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    private int helper(int[] stoneValue, int i) {
        if (i >= stoneValue.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        int res = -inf;
        int sum = 0;
        for (int j = 0; j < 3 && i + j < stoneValue.length; j++) {
            sum += stoneValue[i + j];
            res = Math.max(res, sum - helper(stoneValue, i + j + 1));
        }
        return memo[i] = res;
    }
}
