package finding.pairs.with.a.certain.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class FindingPairsWithACertainSum {
    int[] nums1, nums2;
    Map<Integer, Integer> map = new HashMap<>();

    public FindingPairsWithACertainSum(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }

    public void add(int index, int val) {
        map.put(nums2[index], map.get(nums2[index]) - 1);
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);

    }

    public int count(int tot) {
        int res = 0;
        for (int value : nums1) {
            res += map.getOrDefault(tot - value, 0);
        }
        return res;
    }
}
