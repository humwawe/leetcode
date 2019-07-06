package kth.smallest.element.in.a.bst;

import common.TreeNode;

/**
 * @author hum
 */
public class KthSmallestElementInABst {
    public int kthSmallest(TreeNode root, int k) {
        int left = countTree(root.left);
        if (left + 1 > k) {
            return kthSmallest(root.left, k);
        }
        if (left + 1 < k) {
            return kthSmallest(root.right, k - left - 1);
        }
        if (left + 1 == k) {
            return root.val;
        }
        return 0;
    }


    private int countTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countTree(root.left) + countTree(root.right) + 1;
    }

}
