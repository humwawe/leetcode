package can.make.arithmetic.progression.from.sequence;

import java.util.Arrays;

/**
 * @author hum
 */
public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i] - d != arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
