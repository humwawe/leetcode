package sort.even.and.odd.indices.independently;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class SortEvenAndOddIndicesIndependently {
    public int[] sortEvenOdd(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        list1.sort(Comparator.comparingInt(x -> x));
        list2.sort((x, y) -> y - x);
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                res[i] = list1.get(i / 2);
            } else {
                res[i] = list2.get(i / 2);
            }
        }
        return res;
    }
}
