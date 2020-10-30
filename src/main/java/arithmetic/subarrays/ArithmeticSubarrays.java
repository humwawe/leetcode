package arithmetic.subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        int len = l.length;
        for (int i = 0; i < len; i++) {
            int left = l[i];
            int right = r[i];
            res.add(helper(nums, left, right));
        }
        return res;
    }

    private Boolean helper(int[] nums, int left, int right) {
        if (left + 1 >= right) {
            return true;
        }
        int[] ns = new int[right - left + 1];
        int s = 0;
        for (int i = left; i <= right; i++) {
            ns[s++] = nums[i];
        }
        Arrays.sort(ns);
        int tmp = ns[1] - ns[0];
        for (int i = 1; i < ns.length; i++) {
            if (ns[i] - ns[i - 1] != tmp) {
                return false;
            }
        }
        return true;
    }
}
