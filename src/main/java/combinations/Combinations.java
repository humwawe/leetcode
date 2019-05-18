package combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        helper(0, n, k, 0, results, result);
        return results;
    }

    private void helper(int level, int n, int k, int start, List<List<Integer>> results, List<Integer> result) {
        if (level == k) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = start + 1; i <= n; i++) {
            result.add(i);
            helper(level + 1, n, k, i, results, result);
            result.remove(result.size() - 1);
        }
    }
}
