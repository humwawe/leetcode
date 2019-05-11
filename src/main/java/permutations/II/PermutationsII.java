package permutations.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, 0, results, result, used);
        System.out.println(Arrays.toString(results.toArray()));
        return results;
    }

    private void helper(int[] nums, int i, List<List<Integer>> results, List<Integer> result, boolean[] used) {
        if (nums.length == i) {
            results.add(new ArrayList<>(result));
            return;
        }

        int lastUsed = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++) {
            if (!used[j] && nums[j] != lastUsed) {
                result.add(nums[j]);
                used[j] = true;
                helper(nums, i + 1, results, result, used);
                lastUsed = nums[j];
                result.remove(result.size() - 1);
                used[j] = false;
            }
        }
    }
}
