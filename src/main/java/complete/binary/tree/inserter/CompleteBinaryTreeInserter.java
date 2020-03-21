package complete.binary.tree.inserter;

import common.TreeNode;

/**
 * @author hum
 */
public class CompleteBinaryTreeInserter {
    int size;
    TreeNode[] treeNodes;

    public CompleteBinaryTreeInserter(TreeNode root) {
        treeNodes = new TreeNode[11005];
        size = 0;
        helper(root, 1);
    }

    private void helper(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        treeNodes[i] = root;
        size++;
        helper(root.left, i * 2);
        helper(root.right, i * 2 + 1);
    }

    public int insert(int v) {
        treeNodes[++size] = new TreeNode(v);
        if (size % 2 == 0) {
            treeNodes[size / 2].left = treeNodes[size];
        } else {
            treeNodes[size / 2].right = treeNodes[size];
        }
        return treeNodes[size / 2].val;
    }

    public TreeNode getRoot() {
        return treeNodes[1];
    }
}
