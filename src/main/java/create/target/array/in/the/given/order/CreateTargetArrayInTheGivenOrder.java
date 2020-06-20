package create.target.array.in.the.given.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class CreateTargetArrayInTheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(index[i], nums[i]);
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
