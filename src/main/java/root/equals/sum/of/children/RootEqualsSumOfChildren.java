package root.equals.sum.of.children;

import common.TreeNode;

/**
 * @author hum
 */
public class RootEqualsSumOfChildren {
  public boolean checkTree(TreeNode root) {
    return root.val == root.left.val + root.right.val;
  }
}
