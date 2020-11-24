package ways.to.make.a.fair.array;

/**
 * @author hum
 */
public class WaysToMakeAFairArray {
    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        int[] e = new int[len + 1];
        int[] o = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            if ((i - 1) % 2 == 0) {
                e[i] = e[i - 1] + nums[i - 1];
                o[i] = o[i - 1];
            } else {
                o[i] = o[i - 1] + nums[i - 1];
                e[i] = e[i - 1];
            }
        }
        int odd = 0;
        int even = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (even + o[len] - o[i + 1] == odd + e[len] - e[i + 1]) {
                res++;
            }
            if (i % 2 == 0) {
                even += nums[i];
            } else {
                odd += nums[i];
            }
        }
        return res;
    }
}
