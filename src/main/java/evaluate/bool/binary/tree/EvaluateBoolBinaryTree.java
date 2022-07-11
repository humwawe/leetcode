package evaluate.bool.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class EvaluateBoolBinaryTree {
  public boolean evaluateTree(TreeNode root) {
    if (root.left == null && root.right == null) {
      return root.val != 0;
    }
    if (root.val == 2) {
      return evaluateTree(root.left) || evaluateTree(root.right);
    }
    return evaluateTree(root.left) && evaluateTree(root.right);
  }
}
