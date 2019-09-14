package shuffle.an.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class ShuffleAnArray {
    private List<Integer> list;
    private int[] cache;

    public ShuffleAnArray(int[] nums) {
        cache = new int[nums.length];
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            cache[i] = nums[i];
        }
    }

    public int[] reset() {
        return cache;
    }

    public int[] shuffle() {
        Collections.shuffle(list);
        int[] tmp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i);
        }
        return tmp;
    }
}
