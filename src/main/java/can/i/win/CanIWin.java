package can.i.win;

/**
 * @author hum
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        int[] memo = new int[1 << (maxChoosableInteger + 1)];
        return helper(maxChoosableInteger, desiredTotal, 0, memo);

    }

    private boolean helper(int maxChoosableInteger, int desiredTotal, int vis, int[] memo) {
        if (memo[vis] != 0) {
            return memo[vis] == 1;
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            if ((vis & (1 << i)) == 0) {
                if (i >= desiredTotal || !helper(maxChoosableInteger, desiredTotal - i, vis | (1 << i), memo)) {
                    memo[vis] = 1;
                    return true;
                }
            }
        }
        memo[vis] = 2;
        return false;
    }
}
