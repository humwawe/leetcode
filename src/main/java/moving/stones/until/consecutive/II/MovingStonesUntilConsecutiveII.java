package moving.stones.until.consecutive.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class MovingStonesUntilConsecutiveII {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int len = stones.length;
        int min = len;

        int start = 0;
        int max = Math.max(stones[len - 1] - stones[1] - len + 2, stones[len - 2] - stones[0] - len + 2);
        for (int i = 0; i < stones.length; i++) {
            while (stones[i] - stones[start] >= len) {
                start++;
            }
            if (i - start + 1 == len - 1 && stones[i] - stones[start] == len - 2) {
                min = Math.min(min, 2);
            } else {
                min = Math.min(min, len - (i - start + 1));
            }
        }
        return new int[]{min, max};
    }

}
