package maximum.number.of.coins.you.can.get;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int len = piles.length;
        int cnt = len / 3;
        int res = 0;
        for (int i = len - 2; i >= 0 && cnt > 0; i -= 2) {
            res += piles[i];
            cnt--;
        }
        return res;
    }
}
