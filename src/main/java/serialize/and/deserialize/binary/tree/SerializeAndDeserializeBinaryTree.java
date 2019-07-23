package serialize.and.deserialize.binary.tree;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hum
 */
public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    builder.append(",").append(node.val);
                } else {
                    builder.append(",null");
                }
            }
        }
        builder.deleteCharAt(0);
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] values = data.split(",");
        List<TreeNode> list = new LinkedList<>();
        TreeNode head = createNode(values[0]);
        list.add(head);
        int rootIndex = 0;
        int valueIndex = 1;
        while (rootIndex < list.size()) {
            TreeNode root = list.get(rootIndex++);
            if (valueIndex < values.length) {
                root.left = createNode(values[valueIndex++]);
                root.right = createNode(values[valueIndex++]);
            }
            if (root.left != null) {
                list.add(root.left);
            }
            if (root.right != null) {
                list.add(root.right);
            }
        }
        return head;
    }

    private TreeNode createNode(String str) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase("null")) {
            return null;
        } else {
            int integer = Integer.parseInt(str);
            return new TreeNode(integer);
        }
    }

}
