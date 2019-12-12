package find.duplicate.subtrees;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return result;
    }

    private String helper(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = helper(root.left);
        String right = helper(root.right);
        String tmp = root.val + "-" + left + "-" + right;
        int v = map.getOrDefault(tmp, 0);
        if (v == 1) {
            result.add(root);
        }
        map.put(tmp, v + 1);

        return tmp;
    }
}
