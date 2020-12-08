package frog.jump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        int target = stones[stones.length - 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        for (int stone : stones) {
            for (int k : map.get(stone)) {
                for (int step = k - 1; step <= k + 1; step++) {
                    int num = stone + step;
                    if (num == target) {
                        return true;
                    }
                    if (step > 0 && map.containsKey(num)) {
                        map.get(num).add(step);
                    }
                }
            }
        }
        return false;
    }

}
