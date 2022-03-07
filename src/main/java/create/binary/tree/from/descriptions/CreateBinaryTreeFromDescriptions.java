package create.binary.tree.from.descriptions;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class CreateBinaryTreeFromDescriptions {
  public TreeNode createBinaryTree(int[][] descriptions) {
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    for (int[] description : descriptions) {
      set.add(description[1]);
      TreeNode p = new TreeNode(description[0]);
      TreeNode c = new TreeNode(description[1]);
      if (map.containsKey(description[0])) {
        p = map.get(description[0]);
      }
      if (map.containsKey(description[1])) {
        c = map.get(description[1]);
      }
      if (description[2] == 1) {
        p.left = c;
      } else {
        p.right = c;
      }
      map.put(description[0], p);
      map.put(description[1], c);
    }
    for (Integer integer : map.keySet()) {
      if (!set.contains(integer)) {
        return map.get(integer);
      }
    }
    return null;
  }
}
