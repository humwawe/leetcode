package all.elements.in.two.binary.search.trees;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class AllElementsInTwoBinarySearchTrees {
    List<Integer> result = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        helper(root1);
        helper(root2);
        Collections.sort(result);
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
