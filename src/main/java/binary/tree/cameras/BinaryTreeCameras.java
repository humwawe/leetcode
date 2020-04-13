package binary.tree.cameras;

import common.TreeNode;

/**
 * @author hum
 */
public class BinaryTreeCameras {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (helper(root) == State.NONE) {
            res++;
        }
        return res;
    }

    private State helper(TreeNode root) {
        if (root == null) {
            return State.COVERED;
        }
        State l = helper(root.left);
        State r = helper(root.right);
        if (l == State.NONE || r == State.NONE) {
            res++;
            return State.CAMERA;
        }
        if (l == State.CAMERA || r == State.CAMERA) {
            return State.COVERED;
        }
        return State.NONE;
    }

    enum State {
        NONE,
        COVERED,
        CAMERA
    }
}
