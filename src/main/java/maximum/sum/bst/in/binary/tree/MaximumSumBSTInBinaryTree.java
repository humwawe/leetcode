package maximum.sum.bst.in.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class MaximumSumBSTInBinaryTree {
    int result = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return result;
    }

    private Res helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            result = Math.max(result, root.val);
            return new Res(true, root.val, root.val, root.val);
        }
        Res l = null, r = null;
        if (root.left != null) {
            l = helper(root.left);
        }
        if (root.right != null) {
            r = helper(root.right);
        }

        if (l != null && l.isBst && r != null && r.isBst) {
            boolean f = true;
            if (root.left != null && root.val <= l.max) {
                f = false;
            }
            if (root.right != null && root.val >= r.min) {
                f = false;
            }
            if (f) {
                result = Math.max(result, root.val + l.sum + r.sum);
                return new Res(true, root.val + l.sum + r.sum, l.min, r.max);
            } else {
                result = Math.max(result, Math.max(l.sum, r.sum));
                return new Res(false, 0, -1, -1);
            }
        } else if (l != null && l.isBst) {
            if (r == null) {
                if (root.val > l.max) {
                    result = Math.max(result, root.val + l.sum);
                    return new Res(true, root.val + l.sum, l.min, root.val);
                }

            }
        } else if (r != null && r.isBst) {
            if (l == null) {
                if (root.val < r.min) {
                    result = Math.max(result, root.val + r.sum);
                    return new Res(true, root.val + r.sum, root.val, r.max);
                }
            }
        }
        return new Res(false, 0, -1, -1);

    }

    class Res {
        boolean isBst;
        int sum;
        int min;
        int max;

        public Res(boolean isBst, int sum, int min, int max) {
            this.isBst = isBst;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

}
