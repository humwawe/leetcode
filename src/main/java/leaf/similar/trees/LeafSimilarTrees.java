package leaf.similar.trees;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class LeafSimilarTrees {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs1(root1);
        dfs2(root2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void dfs1(TreeNode root1) {
        if (root1 == null) {
            return;
        }
        if (root1.left == null && root1.right == null) {
            list1.add(root1.val);
            return;
        }
        dfs1(root1.left);
        dfs1(root1.right);
    }

    private void dfs2(TreeNode root2) {
        if (root2 == null) {
            return;
        }
        if (root2.left == null && root2.right == null) {
            list2.add(root2.val);
            return;
        }
        dfs2(root2.left);
        dfs2(root2.right);
    }
}
