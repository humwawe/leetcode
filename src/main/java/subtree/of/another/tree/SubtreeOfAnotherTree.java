package subtree.of.another.tree;

import common.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return true;
        }
        if (s.val == t.val) {
            boolean l = isSubtree(s.left, t.left);
            boolean r = isSubtree(s.right, t.right);
            return l && r;
        }
        return isSubtree(s, t.left) || isSubtree(s, t.right);

    }
}
