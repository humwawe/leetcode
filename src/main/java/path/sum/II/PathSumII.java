package path.sum.II;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        helper(root, sum, results, new ArrayList<>());
        return results;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> results, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(root.val);
            results.add(new ArrayList<>(result));
            result.remove(result.size() - 1);
        }
        result.add(root.val);
        helper(root.left, sum - root.val, results, result);
        helper(root.right, sum - root.val, results, result);
        result.remove(result.size() - 1);
    }
}
