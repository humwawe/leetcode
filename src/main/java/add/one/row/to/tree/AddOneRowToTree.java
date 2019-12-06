package add.one.row.to.tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        d -= 1;
        if (d == 0) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        while (!queue.isEmpty() && d != 0) {
            int size = queue.size();
            d--;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (d == 0) {
                    TreeNode tmp = poll.left;
                    poll.left = new TreeNode(v);
                    poll.left.left = tmp;
                    tmp = poll.right;
                    poll.right = new TreeNode(v);
                    poll.right.right = tmp;
                } else {
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
        }
        return root;
    }
}
