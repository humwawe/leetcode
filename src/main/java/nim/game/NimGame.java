package nim.game;

/**
 * @author hum
 */
public class NimGame {
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        boolean[] result = new boolean[n + 1];
        result[1] = true;
        result[2] = true;
        result[3] = true;
        for (int i = 4; i <= n; i++) {
            if (!result[i - 1] || !result[i - 2] || !result[i - 3]) {
                result[i] = true;
            }
        }
        return result[n];
    }
}
