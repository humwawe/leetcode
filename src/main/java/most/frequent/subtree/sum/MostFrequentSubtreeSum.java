package most.frequent.subtree.sum;

import common.TreeNode;

import java.util.*;

public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        subTreeSum(root, map);
        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }
        List<Integer> ret = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                ret.add(key);
            }
        }
        int[] arr = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            arr[i] = ret.get(i);
        }
        return arr;
    }

    private int subTreeSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = subTreeSum(root.left, map);
        int right = subTreeSum(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
