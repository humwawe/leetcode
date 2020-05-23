package lowest.common.ancestor.of.deepest.leaves;

import common.TreeNode;

/**
 * @author hum
 */
public class LowestCommonAncestorOfDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root).node;
    }

    private Res helper(TreeNode root) {
        if (root == null) {
            return new Res(root, 0);
        }
        Res l = helper(root.left);
        Res r = helper(root.right);
        if (l.depth == r.depth) {
            return new Res(root, l.depth + 1);
        }
        if (l.depth > r.depth) {
            return new Res(l.node, l.depth + 1);
        } else {
            return new Res(r.node, r.depth + 1);
        }

    }

    class Res {
        TreeNode node;
        int depth;

        public Res(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
