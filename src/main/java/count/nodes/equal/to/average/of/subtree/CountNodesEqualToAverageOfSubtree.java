package count.nodes.equal.to.average.of.subtree;

import common.TreeNode;

/**
 * @author hum
 */
public class CountNodesEqualToAverageOfSubtree {
  int res;

  public int averageOfSubtree(TreeNode root) {
    average(root);
    return res;
  }

  private int[] average(TreeNode root) {
    int[] res = new int[]{0, 0};
    if (root == null) {
      return res;
    }
    int[] left = average(root.left);
    int[] right = average(root.right);
    int sum = left[0] + right[0] + root.val;
    int num = left[1] + right[1] + 1;

    if (sum / num == root.val) {
      this.res++;
    }

    return new int[]{sum, num};

  }

}
