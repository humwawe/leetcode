package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        helper(0, nums, -1, results, result);
        return results;
    }

    private void helper(int level, int[] nums, int start, List<List<Integer>> results, List<Integer> result) {
        if (level <= nums.length) {
            results.add(new ArrayList<>(result));
        }
        for (int i = start + 1; i < nums.length; i++) {
            result.add(nums[i]);
            helper(level + 1, nums, i, results, result);
            result.remove(result.size() - 1);
        }
    }
}
