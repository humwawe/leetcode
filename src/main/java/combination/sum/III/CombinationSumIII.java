package combination.sum.III;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class CombinationSumIII {
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 0, 1, 0, new ArrayList<>());
        return results;
    }

    private void helper(int k, int n, int level, int start, int sum, ArrayList<Integer> result) {
        if (level == k && sum == n) {
            results.add(new ArrayList<>(result));
        }
        if (level >= k || sum > n) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            result.add(i);
            helper(k, n, level + 1, i + 1, sum + i, result);
            result.remove(result.size() - 1);
        }
    }
}
