package increasing.order.search.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return helper(list, 0);
    }

    private TreeNode helper(List<Integer> list, int i) {
        if (i == list.size()) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(i));
        root.right = helper(list, i + 1);
        return root;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }
    }
}
