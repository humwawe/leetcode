package increasing.subsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class IncreasingSubsequences {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, new ArrayList<>(), 0);
        return result;

    }

    private void helper(int[] nums, ArrayList<Integer> tmp, int start) {
        if (tmp.size() > 1) {
            result.add(new ArrayList<>(tmp));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (tmp.isEmpty() || nums[i] >= tmp.get(tmp.size() - 1)) {
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                    tmp.add(nums[i]);
                    helper(nums, tmp, i + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
