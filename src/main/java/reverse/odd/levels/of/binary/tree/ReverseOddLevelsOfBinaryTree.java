package reverse.odd.levels.of.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class ReverseOddLevelsOfBinaryTree {
  public TreeNode reverseOddLevels(TreeNode root) {
    dfs(root.left, root.right, 1);
    return root;
  }

  void dfs(TreeNode l, TreeNode r, int level) {
    if (l == null) {
      return;
    }
    if (level % 2 != 0) {
      int val = r.val;
      r.val = l.val;
      l.val = val;
    }
    dfs(l.left, r.right, level + 1);
    dfs(l.right, r.left, level + 1);
  }

}
