package smallest.subtree.with.all.the.deepest.nodes;

import common.TreeNode;

/**
 * @author hum
 */
public class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).node;

    }

    private Res helper(TreeNode root) {
        if (root == null) {
            return new Res(0, root);
        }
        Res l = helper(root.left);
        Res r = helper(root.right);
        if (l.dist > r.dist) {
            return new Res(l.dist + 1, l.node);
        }
        if (l.dist < r.dist) {
            return new Res(r.dist + 1, r.node);
        }
        return new Res(l.dist + 1, root);
    }

    class Res {
        int dist;
        TreeNode node;

        public Res(int dist, TreeNode node) {
            this.dist = dist;
            this.node = node;
        }
    }
}
