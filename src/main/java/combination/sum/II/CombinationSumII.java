package combination.sum.II;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, results, result, 0);
        return results;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> results, List<Integer> result, int level) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            if (i != level && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int num = candidates[i];
            if (num <= target) {
                result.add(num);
                helper(candidates, target - num, results, result, i + 1);
                result.remove(result.size() - 1);
            } else {
                break;
            }
        }
    }
}
