package smallest.rotation.with.highest.score;

import java.util.Arrays;

/**
 * @author hum
 */
public class SmallestRotationWithHighestScore {
    public int bestRotation(int[] arr) {
        int len = arr.length;
        int[] tmp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (i - arr[i] >= 0) {
                tmp[0] += 1;
                tmp[i - arr[i] + 1] -= 1;
                tmp[i + 1] += 1;
                tmp[len] -= 1;
            }
            if (i - arr[i] < 0) {
                tmp[i + 1] += 1;
                tmp[i - arr[i] + len + 1] -= 1;
            }
        }
        System.out.println(Arrays.toString(tmp));
        int result = 0;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            sum += tmp[i];
            if (sum > max) {
                max = sum;
                result = i;
            }
        }
        return result;
    }
}
