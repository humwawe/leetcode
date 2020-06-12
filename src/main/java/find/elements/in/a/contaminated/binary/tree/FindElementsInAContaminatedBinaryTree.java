package find.elements.in.a.contaminated.binary.tree;

import common.TreeNode;

import java.util.*;

/**
 * @author hum
 */
public class FindElementsInAContaminatedBinaryTree {
    TreeNode root;
    Set<Integer> set = new HashSet<>();

    public FindElementsInAContaminatedBinaryTree(TreeNode root) {
        this.root = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
            root.val = 0;
            set.add(0);
        }
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
                poll.left.val = poll.val * 2 + 1;
                set.add(poll.val * 2 + 1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                poll.right.val = poll.val * 2 + 2;
                set.add(poll.val * 2 + 2);
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
