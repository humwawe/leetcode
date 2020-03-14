package all.possible.full.binary.trees;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n % 2 == 0) {
            return result;
        }
        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        for (int i = 1; i <= n - 2; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
