package minimum.distance.between.bst.nodes;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class MinimumDistanceBetweenBstNodes {
    List<Integer> res = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        helper(root);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < res.size(); i++) {
            result = Math.min(result, res.get(i) - res.get(i - 1));
        }
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
}
