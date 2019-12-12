package maximum.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        return helper(nums, 0, len - 1);
    }

    private TreeNode helper(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int index = getMax(nums, i, j);
        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, i, index - 1);
        root.right = helper(nums, index + 1, j);
        return root;
    }

    private int getMax(int[] nums, int i, int j) {
        int index = i;
        for (int k = i + 1; k <= j; k++) {
            if (nums[k] > nums[index]) {
                index = k;
            }
        }
        return index;
    }
}
