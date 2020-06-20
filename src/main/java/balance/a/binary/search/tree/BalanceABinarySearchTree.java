package balance.a.binary.search.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class BalanceABinarySearchTree {
    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        dfs(root);
        return helper(list, 0, list.size() - 1);
    }

    private TreeNode helper(List<Integer> list, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list, i, mid - 1);
        root.right = helper(list, mid + 1, j);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
