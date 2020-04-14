package flip.binary.tree.to.match.preorder.traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FlipBinaryTreeToMatchPreorderTraversal {
    List<Integer> list = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (helper(root, voyage, 0, voyage.length - 1)) {
            return list;
        } else {
            list.clear();
            list.add(-1);
            return list;
        }
    }

    private boolean helper(TreeNode root, int[] voyage, int i, int j) {
        if (root == null) {
            return true;
        }
        if (root.val != voyage[i]) {
            return false;
        }
        if (root.left != null && root.right != null) {
            int a = -1;
            int b = -1;
            for (int k = i + 1; k <= j; k++) {
                if (root.left.val == voyage[k]) {
                    a = k;
                }
                if (root.right.val == voyage[k]) {
                    b = k;
                }
            }
            if (a == -1 || b == -1) {
                return false;
            }
            if (a != i + 1 && b != i + 1) {
                return false;
            }
            System.out.println(a);
            System.out.println(b);
            if (a > b) {
                list.add(root.val);
                return helper(root.left, voyage, a, j) && helper(root.right, voyage, b, a - 1);
            } else {
                return helper(root.left, voyage, a, b - 1) && helper(root.right, voyage, b, j);
            }
        }
        if (root.left != null && root.right == null) {
            return helper(root.left, voyage, i + 1, j);
        }
        if (root.right != null && root.left == null) {
            return helper(root.right, voyage, i + 1, j);
        }
        return root.val == voyage[i];
    }
}
