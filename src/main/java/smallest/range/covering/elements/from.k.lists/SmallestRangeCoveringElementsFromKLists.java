package smallest.range.covering.elements.from.k.lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author hum
 */
public class SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {

        List<TreeSet<Integer>> treeSets = new ArrayList<>();
        int len = nums.size();
        if (len == 1) {
            return new int[]{nums.get(0).get(0), nums.get(0).get(0)};
        }
        for (List<Integer> num : nums) {
            TreeSet<Integer> treeSet = new TreeSet<>(num);
            treeSets.add(treeSet);
        }
        int[] result = new int[2];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            for (Integer l : treeSets.get(i)) {
                int r = Integer.MIN_VALUE;
                boolean flag = true;
                for (int k = 0; k < len; k++) {
                    if (k == i) {
                        continue;
                    }
                    Integer tmp = treeSets.get(k).ceiling(l);
                    if (tmp == null) {
                        flag = false;
                        break;
                    }
                    r = Math.max(r, tmp);
                    if (r - l > res) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (res > r - l) {
                        res = r - l;
                        result[0] = l;
                        result[1] = r;
                    } else if (res == r - l && result[0] > l) {
                        result[0] = l;
                        result[1] = r;
                    }
                }
            }
        }
        return result;
    }

    public int[] smallestRange2(List<List<Integer>> nums) {
        int len = nums.size();
        if (len == 1) {
            return new int[]{nums.get(0).get(0), nums.get(0).get(0)};
        }
        TreeSet<int[]> treeSet = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] next = new int[len];
        for (int i = 0; i < len; i++) {
            treeSet.add(new int[]{nums.get(i).get(0), i});
        }
        int res = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (true) {
            int[] min = treeSet.first();
            int l = min[0];
            int r = treeSet.last()[0];
            if (res > r - l) {
                res = r - l;
                result[0] = l;
                result[1] = r;
            } else if (res == r - l && result[0] > l) {
                result[0] = l;
                result[1] = r;
            }
            int index = min[1];
            next[index]++;
            if (next[index] == nums.get(index).size()) {
                break;
            }
            treeSet.remove(min);
            treeSet.add(new int[]{nums.get(index).get(next[index]), index});
        }
        return result;
    }
}
