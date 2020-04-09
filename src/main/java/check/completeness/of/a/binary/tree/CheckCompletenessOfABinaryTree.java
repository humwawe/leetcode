package check.completeness.of.a.binary.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hum
 */
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int curCount = queue.size();
            for (int i = 0; i < curCount; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    if (flag) {
                        return false;
                    }
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                } else {
                    flag = true;
                }
            }
        }
        return true;
    }
}
