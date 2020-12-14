package stone.game.VI;

import java.util.Arrays;

/**
 * @author hum
 */
public class StoneGameVI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int len = aliceValues.length;
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (x, y) -> aliceValues[y] + bobValues[y] - aliceValues[x] - aliceValues[x]);
        int a = 0;
        int b = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                a += aliceValues[idx[i]];
            } else {
                b += bobValues[idx[i]];
            }
        }
        return Integer.compare(a, b);
    }
}
