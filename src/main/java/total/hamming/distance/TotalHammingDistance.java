package total.hamming.distance;

import java.util.Arrays;

/**
 * @author hum
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        int[][] tmp = new int[32][2];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & 1) == 1) {
                    tmp[i][1]++;
                } else {
                    tmp[i][0]++;
                }
                num >>= 1;
            }
        }
        System.out.println(Arrays.deepToString(tmp));
        for (int[] ints : tmp) {
            result += ints[0] * ints[1];
        }
        return result;
    }

}
