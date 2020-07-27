package number.of.good.leaf.nodes.pairs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class NumberOfGoodLeafNodesPairs {
    int result = 0;

    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);
        return result;
    }

    private List<Integer> helper(TreeNode root, int distance) {
        if (root != null && root.left == null && root.right == null) {
            List<Integer> t = new ArrayList<>();
            t.add(1);
            return t;
        }
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = helper(root.left, distance);
        List<Integer> right = helper(root.right, distance);
        for (Integer l : left) {
            for (Integer r : right) {
                if (l + r <= distance) {
                    result++;
                }
            }
        }
        List<Integer> all = new ArrayList<>();
        for (Integer l : left) {
            all.add(l + 1);
        }
        for (Integer r : right) {
            all.add(r + 1);
        }
        return all;
    }
}
