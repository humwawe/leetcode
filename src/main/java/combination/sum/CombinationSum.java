package combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            int num = candidates[i];
            if (num <= target) {
                result.add(num);
                helper(candidates, target - num, results, result, i);
                result.remove(result.size() - 1);
            } else {
                break;
            }
        }
    }
}
