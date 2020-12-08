package sliding.window.median;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length + 1 - k];
        List<Integer> list = new ArrayList<>();
        int index, pos;

        for (int i = 0; i < k; i++) {
            pos = binarysearch(list, nums[i]);
            list.add(pos, nums[i]);
        }
        res[0] = ((double) list.get((k - 1) / 2) + (double) list.get(k / 2)) / 2.0;

        for (int end = k; end < nums.length; end++) {
            index = binarysearch(list, nums[end - k]);
            list.remove(index);
            pos = binarysearch(list, nums[end]);
            list.add(pos, nums[end]);
            res[end + 1 - k] = ((double) list.get((k - 1) / 2) + (double) list.get(k / 2)) / 2.0;
        }
        return res;
    }


    private int binarysearch(List<Integer> data, int target) {
        int l = 0, r = data.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (data.get(m) > target) {
                r = m - 1;
            } else if (data.get(m) < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }
}
