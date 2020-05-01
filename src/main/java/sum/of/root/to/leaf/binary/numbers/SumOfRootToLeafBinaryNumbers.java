package sum.of.root.to.leaf.binary.numbers;

import common.TreeNode;

/**
 * @author hum
 */
public class SumOfRootToLeafBinaryNumbers {
    int result = 0;

    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum = sum * 2 + root.val;
            result += sum;
            return;
        }
        helper(root.left, sum * 2 + root.val);
        helper(root.right, sum * 2 + root.val);
    }
}
