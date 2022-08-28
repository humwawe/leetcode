package amount.of.time.binary.tree.to.be.infected;

import common.TreeNode;

/**
 * @author hum
 */
public class AmountOfTimeForBinaryTreeToBeInfected {
  int res = 0;
  int depth = -1;

  public int amountOfTime(TreeNode root, int start) {
    dfs(root, 0, start);
    return res;
  }

  int dfs(TreeNode root, int level, int start) {
    if (root == null) {
      return 0;
    }
    if (root.val == start) {
      depth = level;
    }
    int l = dfs(root.left, level + 1, start);
    boolean inLeft = depth != -1;
    int r = dfs(root.right, level + 1, start);
    if (root.val == start) {
      res = Math.max(res, Math.max(l, r));
    }
    if (inLeft) {
      res = Math.max(res, depth - level + r);
    } else {
      res = Math.max(res, depth - level + l);
    }
    return Math.max(l, r) + 1;
  }

}
