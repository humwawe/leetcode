package circular.array.loop;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        boolean[] vis = new boolean[len];

        for (int i = 0; i < len; i++) {
            Set<Integer> set = new HashSet<>();
            if (!vis[i]) {
                int index = i;
                boolean flag = nums[index] > 0;
                while (true) {
                    if (nums[index] < 0 && flag || (nums[index] > 0 && !flag)) {
                        break;
                    }
                    vis[index] = true;
                    if (set.contains(index)) {
                        return true;
                    }
                    set.add(index);
                    int nextIndex = (index + nums[index]) % len;
                    if (nextIndex < 0) {
                        nextIndex += len;
                    }
                    if (nextIndex != index) {
                        index = nextIndex;
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }
}
