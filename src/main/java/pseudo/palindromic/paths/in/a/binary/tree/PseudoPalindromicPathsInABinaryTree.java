package pseudo.palindromic.paths.in.a.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class PseudoPalindromicPathsInABinaryTree {
    int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];
        helper(root, count);
        return result;
    }

    private void helper(TreeNode root, int[] count) {
        if (root.left == null && root.right == null) {
            count[root.val]++;
            if (check(count)) {
                result++;
            }
            count[root.val]--;
            return;
        }
        count[root.val]++;
        if (root.left != null) {
            helper(root.left, count);
        }
        if (root.right != null) {
            helper(root.right, count);
        }
        count[root.val]--;
    }

    private boolean check(int[] count) {
        int res = 0;
        for (int i = 0; i <= 9; i++) {
            if (count[i] % 2 == 1) {
                res++;
            }
        }
        return res <= 1;
    }
}
