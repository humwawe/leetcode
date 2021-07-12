package merge.bsts.to.create.single.bst;

import common.TreeNode;

import java.util.*;

/**
 * @author hum
 */
public class MergeBstsToCreateSingleBst {
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> del = new HashSet<>();
    TreeNode cur;
    boolean res = true;

    public TreeNode canMerge(List<TreeNode> trees) {
        for (TreeNode tree : trees) {
            map.put(tree.val, tree);
        }

        for (Integer val : map.keySet()) {
            if (!res) {
                return null;
            }
            if (del.contains(val)) {
                continue;
            }
            cur = map.get(val);
            dfs(map.get(val));
        }
        if (del.size() == trees.size() - 1) {
            for (Integer val : map.keySet()) {
                if (!del.contains(val)) {
                    if (check(map.get(val))) {
                        return map.get(val);
                    }
                    break;
                }
            }
        }
        return null;
    }

    boolean isBst(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return isBst(root.left, min, root.val - 1) && isBst(root.right, root.val + 1, max);
    }

    private boolean check(TreeNode root) {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void dfs(TreeNode root) {
        if (del.contains(root.val)) {
            return;
        }
        if (root.left == null && root.right == null) {
            TreeNode treeNode = map.get(root.val);
            if (treeNode == null || treeNode == root) {
                return;
            }
            if (treeNode == cur) {
                res = false;
                return;
            }
            root.left = treeNode.left;
            root.right = treeNode.right;
            del.add(treeNode.val);
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
