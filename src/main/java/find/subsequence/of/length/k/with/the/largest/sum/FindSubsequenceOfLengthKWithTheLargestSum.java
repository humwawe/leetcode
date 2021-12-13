package find.subsequence.of.length.k.with.the.largest.sum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class FindSubsequenceOfLengthKWithTheLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (x, y) -> nums[y] - nums[x]);
        int[] res = new int[k];
        List<Integer> list = Arrays.asList(idx).subList(0, k);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            res[i] = nums[list.get(i)];
        }
        return res;
    }
}
