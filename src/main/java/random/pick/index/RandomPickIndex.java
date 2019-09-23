package random.pick.index;

import java.util.*;

/**
 * @author hum
 */
public class RandomPickIndex {
    Map<Integer, List<Integer>> map;

    public RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            }
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int size = list.size();
        return list.get(new Random().nextInt(size));
    }
}
