package convert.sorted.array.to.binary.search.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left >> 1);
        TreeNode head = new TreeNode(nums[mid]);

        head.left = helper(nums, left, mid - 1);
        head.right = helper(nums, mid + 1, right);
        return head;
    }
}
