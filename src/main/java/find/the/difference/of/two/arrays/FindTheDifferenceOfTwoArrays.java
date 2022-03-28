package find.the.difference.of.two.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class FindTheDifferenceOfTwoArrays {
  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    res.add(new ArrayList<>());
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    for (int i : nums1) {
      set1.add(i);
    }
    for (int i : nums2) {
      set2.add(i);
    }
    for (Integer integer : set1) {
      if (set2.contains(integer)) {
        continue;
      }
      res.get(0).add(integer);
    }
    for (Integer integer : set2) {
      if (set1.contains(integer)) {
        continue;
      }
      res.get(1).add(integer);
    }
    return res;
  }
}
