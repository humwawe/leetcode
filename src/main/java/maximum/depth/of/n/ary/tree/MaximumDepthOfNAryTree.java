package maximum.depth.of.n.ary.tree;

import common.NAryNode;


public class MaximumDepthOfNAryTree {
    public int maxDepth(NAryNode root) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        for (NAryNode child : root.children) {
            result = Math.max(result, maxDepth(child) + 1);
        }
        return result;
    }
}
