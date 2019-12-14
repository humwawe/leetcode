package maximum.width.of.binary.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hum
 */
public class MaximumWidthOfBinaryTree {
    private int result = 1;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        queue.add(root);
        indexList.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = indexList.removeFirst();
                if (node.left != null) {
                    queue.add(node.left);
                    indexList.add(2 * index);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    indexList.add(2 * index + 1);
                }
            }
            if (indexList.size() >= 2) {
                result = Math.max(result, indexList.getLast() - indexList.getFirst() + 1);
            }
        }
        return result;
    }
}
