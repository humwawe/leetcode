package recover.a.tree.from.preorder.traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author hum
 */
public class RecoverATreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String s) {
        int len = s.length();
        List<int[]> list = new ArrayList<>();
        int count = 0;
        int val = 0;
        for (char c : s.toCharArray()) {
            if (c == '-') {
                if (val != 0) {
                    list.add(new int[]{count, val});
                    count = 0;
                    val = 0;
                }
                count++;
            } else {
                val = val * 10 + c - '0';
            }
        }
        list.add(new int[]{count, val});
        return helper(list, 0, list.size());
    }

    private TreeNode helper(List<int[]> list, int i, int j) {
        if (i >= j) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(i)[1]);
        if (i == j - 1) {
            return root;
        }
        int l = list.get(i + 1)[0];
        int idx = i + 2;
        for (; idx < j; idx++) {
            if (list.get(idx)[0] == l) {
                root.right = helper(list, idx, j);
                break;
            }
        }
        root.left = helper(list, i + 1, idx);
        return root;
    }
}
