package subtree.of.another.tree;

import common.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return helper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            boolean l = isSubtree(s.left, t.left);
            boolean r = isSubtree(s.right, t.right);
            return l && r;
        }
        return false;
    }


}
