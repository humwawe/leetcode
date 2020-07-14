package stone.game.IV;

/**
 * @author hum
 */
public class StoneGameIV {
    Boolean[] memo = new Boolean[(int) 1e5 + 5];

    public boolean winnerSquareGame(int n) {
        return helper(n);
    }

    private boolean helper(int n) {
        if (n == 1) {
            return true;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        for (int i = 1; i * i <= n; i++) {
            if (!helper(n - i * i)) {
                return memo[n] = true;
            }
        }
        return memo[n] = false;
    }
}
