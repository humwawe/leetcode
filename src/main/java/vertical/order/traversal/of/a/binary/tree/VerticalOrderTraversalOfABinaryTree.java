package vertical.order.traversal.of.a.binary.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author hum
 */
public class VerticalOrderTraversalOfABinaryTree {
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root, 1000, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            List<Integer> list = map.get(integer);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) % 10000);
            }
            result.add(map.get(integer));

        }
        return result;
    }

    private void helper(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        List<Integer> list = map.getOrDefault(x, new ArrayList<>());
        list.add(root.val + y * 10000);
        map.put(x, list);
        helper(root.left, x - 1, y + 1);

        helper(root.right, x + 1, y + 1);
    }
}
