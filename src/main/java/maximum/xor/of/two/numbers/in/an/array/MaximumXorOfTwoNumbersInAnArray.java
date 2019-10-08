package maximum.xor.of.two.numbers.in.an.array;

import common.TreeNode;

/**
 * @author hum
 */
public class MaximumXorOfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        TreeNode root = new TreeNode(-1);
        for (int num : nums) {
            TreeNode tmp = root;
            for (int i = 31; i >= 0; i--) {
                if ((num & (1 << i)) == 0) {
                    if (tmp.left == null) {
                        tmp.left = new TreeNode(0);
                    }
                    tmp = tmp.left;
                } else {
                    if (tmp.right == null) {
                        tmp.right = new TreeNode(1);
                    }
                    tmp = tmp.right;
                }
            }
            tmp.left = new TreeNode(num);
        }

        int result = 0;
        for (int num : nums) {
            TreeNode tmp = root;
            for (int i = 31; i >= 0; i--) {
                if ((num & (1 << i)) == 0) {
                    if (tmp.right != null) {
                        tmp = tmp.right;
                    } else {
                        tmp = tmp.left;
                    }
                } else {
                    if (tmp.left != null) {
                        tmp = tmp.left;
                    } else {
                        tmp = tmp.right;
                    }
                }
            }
            result = Math.max(result, num ^ tmp.left.val);
        }

        return result;
    }
}
