package height.of.binary.tree.after.subtree.removal.queries;

import common.TreeNode;

/**
 * @author hum
 */
public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {
  int[] h = new int[100005];
  int[] res = new int[100005];

  public int[] treeQueries(TreeNode root, int[] queries) {
    getHeight(root);
    dfs(root, 0, 0);
    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      res[i] = res[queries[i]];
    }
    return res;
  }

  void dfs(TreeNode root, int rt, int depth) {
    if (root == null) {
      return;
    }
    res[root.val] = rt;
    dfs(root.left, Math.max(depth + (root.right == null ? 0 : h[root.right.val]), rt), depth + 1);
    dfs(root.right, Math.max(depth + (root.left == null ? 0 : h[root.left.val]), rt), depth + 1);
  }

  int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return h[root.val] = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

}
