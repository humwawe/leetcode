package intersection.of.two.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] result = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            result[i++] = integer;
        }
        return result;
    }
}
