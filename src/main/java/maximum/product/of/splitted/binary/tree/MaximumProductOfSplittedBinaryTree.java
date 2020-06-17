package maximum.product.of.splitted.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class MaximumProductOfSplittedBinaryTree {
    long result = 0;
    long sum = 0;
    int mod = (int) (1e9 + 7);

    public int maxProduct(TreeNode root) {
        sum = helper1(root);
        helper(root);
        return (int) (result % mod);
    }

    private long helper1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long l = helper1(root.left);
        long r = helper1(root.right);
        return l + r + root.val;
    }

    private long helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long l = helper(root.left);
        long r = helper(root.right);
        result = Math.max(result, l * (sum - l));
        result = Math.max(result, r * (sum - r));
        return l + r + root.val;
    }
}
