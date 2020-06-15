package maximum.candies.you.can.get.from.boxes;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class MaximumCandiesYouCanGetFromBoxes {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int len = status.length;
        int result = 0;
        Set<Integer> key = new HashSet<>();
        Set<Integer> box = new HashSet<>();
        for (int i = 0; i < status.length; i++) {
            if (status[i] == 1) {
                key.add(i);
            }
        }
        for (int initialBox : initialBoxes) {
            if (key.contains(initialBox)) {
                int[] containedBox = containedBoxes[initialBox];
                for (int i : containedBox) {
                    box.add(i);
                }
            }
            box.add(initialBox);
        }
        boolean[] vis = new boolean[len];
        while (true) {
            boolean found = false;
            Set<Integer> newKey = new HashSet<>();
            Set<Integer> newBox = new HashSet<>();
            for (Integer k : key) {
                if (vis[k]) {
                    continue;
                }
                if (box.contains(k)) {
                    result += candies[k];
                    found = true;
                    int[] key1 = keys[k];
                    for (int i : key1) {
                        newKey.add(i);
                    }
                    int[] containedBox = containedBoxes[k];
                    for (int i : containedBox) {
                        newBox.add(i);
                    }
                    vis[k] = true;
                }
            }
            if (!found) {
                break;
            }
            key.addAll(newKey);
            box.addAll(newBox);
        }
        return result;
    }
}
