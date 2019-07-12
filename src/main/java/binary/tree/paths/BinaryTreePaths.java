package binary.tree.paths;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class BinaryTreePaths {
    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        helper(root, "");
        return result;
    }

    private void helper(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            result.add(s + root.val);
        }
        helper(root.left, s + root.val + "->");
        helper(root.right, s + root.val + "->");
    }
}
