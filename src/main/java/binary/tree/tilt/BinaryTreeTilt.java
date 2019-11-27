package binary.tree.tilt;

import common.TreeNode;

public class BinaryTreeTilt {
    private int result = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return result;
    }

    private RetType helper(TreeNode root) {
        if (root == null) {
            return new RetType(0, 0);
        }
        RetType l = helper(root.left);
        RetType r = helper(root.right);
        int tmp = Math.abs(l.sum - r.sum);
        result += tmp;
        return new RetType(tmp, l.sum + r.sum + root.val);
    }

    class RetType {
        int tilt;
        int sum;

        public RetType(int tilt, int sum) {
            this.tilt = tilt;
            this.sum = sum;
        }
    }
}
