package frequency.of.the.most.frequent.element;

import java.util.Arrays;

/**
 * @author hum
 */
public class FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int j = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            while (j < i) {
                int tmp = nums[i] * (i - j + 1) - (sum[i + 1] - sum[j]);
                if (tmp > k) {
                    j++;
                } else {
                    break;
                }
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
