package smallest.string.starting.from.leaf;

import common.TreeNode;

/**
 * @author hum
 */
public class SmallestStringStartingFromLeaf {
    String result;

    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return result;
    }

    private void helper(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            System.out.println(s);
            String t = (char) ('a' + root.val) + s;
            if (result == null) {
                result = t;
            } else {
                if (result.compareTo(t) > 0) {
                    result = t;
                }
            }
            return;
        }
        if (root.left != null) {
            helper(root.left, (char) ('a' + root.val) + s);
        }
        if (root.right != null) {
            helper(root.right, (char) ('a' + root.val) + s);
        }
    }
}
