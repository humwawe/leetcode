package maximum.number.of.consecutive.values.you.can.make;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumNumberOfConsecutiveValuesYouCanMake {
    public int getMaximumConsecutive(int[] coins) {
        int cur = 0;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin <= cur + 1) {
                cur += coin;
            } else {
                break;
            }
        }
        return cur + 1;
    }
}
