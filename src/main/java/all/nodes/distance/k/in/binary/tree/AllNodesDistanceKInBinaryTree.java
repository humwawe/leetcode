package all.nodes.distance.k.in.binary.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class AllNodesDistanceKInBinaryTree {
    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, target, k);
        return result;
    }

    private int dfs(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return -1;
        }
        if (root.val == target.val) {
            helper(target, k);
            return 0;
        }
        int l = dfs(root.left, target, k);
        int r = dfs(root.right, target, k);
        if (l >= 0) {
            if (l + 1 == k) {
                result.add(root.val);
            }
            helper(root.right, k - l - 2);
            return l + 1;
        }
        if (r >= 0) {
            if (r + 1 == k) {
                result.add(root.val);
            }
            helper(root.left, k - r - 2);
            return r + 1;
        }
        return -1;
    }

    private void helper(TreeNode root, int k) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            result.add(root.val);
            return;
        }
        helper(root.left, k - 1);
        helper(root.right, k - 1);
    }
}
