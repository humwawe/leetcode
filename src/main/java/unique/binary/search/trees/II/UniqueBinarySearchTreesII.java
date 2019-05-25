package unique.binary.search.trees.II;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> results = new ArrayList<>();
        if (n < 1) {
            return results;
        }
        if (n == 1) {
            results.add(new TreeNode(1));
            return results;
        }
        List<TreeNode> treeNodes = generateTrees(n - 1);
        for (int i = 0; i < treeNodes.size(); i++) {
            TreeNode tmp = new TreeNode(n);
            tmp.left = helper(treeNodes.get(i));
            results.add(tmp);
            int count = 0;
            while (true) {
                TreeNode head = helper(treeNodes.get(i));
                TreeNode headTemp = head;
                for (int j = 0; j < count; j++) {
                    headTemp = headTemp.right;
                }
                if (headTemp == null) {
                    break;
                }
                TreeNode tmp1 = new TreeNode(n);
                tmp1.left = headTemp.right;
                headTemp.right = tmp1;
                results.add(head);
                count++;
            }
        }
        return results;

    }

    private TreeNode helper(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode head = new TreeNode(node.val);
        head.left = helper(node.left);
        head.right = helper(node.right);
        return head;
    }
}
