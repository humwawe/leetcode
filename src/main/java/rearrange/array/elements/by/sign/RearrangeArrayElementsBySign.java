package rearrange.array.elements.by.sign;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }
        int[] res = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < list1.size(); i++) {
            res[idx++] = list1.get(i);
            res[idx++] = list2.get(i);
        }
        return res;
    }
}
