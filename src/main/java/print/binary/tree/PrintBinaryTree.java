package print.binary.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int depth = getDepth(root);
        int width = (int) (Math.pow(2, depth) - 1);
        String[][] res = new String[depth][width];
        List<List<String>> result = new ArrayList<>();
        fill(res, 0, 0, width - 1, root);
        for (String[] strings : res) {
            List<String> tmp = new ArrayList<>();
            for (String string : strings) {
                if (string == null) {
                    tmp.add("");
                } else {
                    tmp.add(string);
                }
            }
            result.add(tmp);
        }
        return result;
    }

    private void fill(String[][] res, int depth, int start, int end, TreeNode node) {
        if (node == null) {
            return;
        }
        int mid = (start + end) / 2;
        res[depth][mid] = String.valueOf(node.val);
        fill(res, depth + 1, start, mid - 1, node.left);
        fill(res, depth + 1, mid + 1, end, node.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left) + 1;
        int right = getDepth(root.right) + 1;
        return right > left ? right : left;
    }
}
