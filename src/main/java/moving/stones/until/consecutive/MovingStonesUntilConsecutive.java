package moving.stones.until.consecutive;

import java.util.Arrays;

/**
 * @author hum
 */
public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int[] tmp = new int[3];
        tmp[0] = a;
        tmp[1] = b;
        tmp[2] = c;
        Arrays.sort(tmp);
        if (tmp[0] == tmp[1] - 1 && tmp[1] == tmp[2] - 1) {
            return new int[]{0, 0};
        }
        int min = 2;
        if (tmp[0] == tmp[1] - 2 || tmp[1] == tmp[2] - 2 || tmp[0] == tmp[1] - 1 || tmp[1] == tmp[2] - 1) {
            min = 1;
        }
        return new int[]{min, tmp[2] - tmp[0] - 2};
    }
}
