package subsets.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, -1, results, result);
        return results;
    }

    private void helper(int level, int[] nums, int start, List<List<Integer>> results, List<Integer> result) {
        if (level <= nums.length) {
            results.add(new ArrayList<>(result));
        }
        Integer lastUsed = null;
        for (int i = start + 1; i < nums.length; i++) {
            if (lastUsed != null && lastUsed.equals(nums[i])) {
                continue;
            }
            result.add(nums[i]);
            helper(level + 1, nums, i, results, result);
            result.remove(result.size() - 1);
            lastUsed = nums[i];
        }
    }
}
