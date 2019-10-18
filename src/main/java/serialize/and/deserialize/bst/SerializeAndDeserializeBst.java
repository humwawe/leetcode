package serialize.and.deserialize.bst;

import common.TreeNode;


/**
 * @author hum
 */
public class SerializeAndDeserializeBst {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        return builder(arr, 0, arr.length - 1);
    }

    private TreeNode builder(String[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(arr[lo]));
        int index = hi + 1;
        for (int i = lo + 1; i <= hi; i++) {
            if (Integer.valueOf(arr[i]) > root.val) {
                index = i;
                break;
            }
        }
        root.left = builder(arr, lo + 1, index - 1);
        root.right = builder(arr, index, hi);
        return root;
    }

    public static void main(String[] args) {
        String[] s = "#_".split("_");
        System.out.println(s.length);
    }
}
