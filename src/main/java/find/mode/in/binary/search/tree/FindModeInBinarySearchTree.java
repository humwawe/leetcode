package find.mode.in.binary.search.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindModeInBinarySearchTree {
    private int cur = 1;
    private int max = 0;
    private TreeNode pre = null;
    private List<Integer> res = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        helper(root);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre != null) {
            if (root.val == pre.val) {
                cur++;
            } else {
                cur = 1;
            }
        }
        if (cur == max) {
            res.add(root.val);
        }
        if (cur > max) {
            max = cur;
            res.clear();
            res.add(root.val);
        }
        pre = root;
        helper(root.right);
    }
}
