package random.point.in.non.overlapping.rectangles;

import java.util.Random;
import java.util.TreeMap;

public class RandomPointInNonOverlappingRectangles {
    TreeMap<Integer, Integer> map;
    int[][] rects;
    int sum;
    Random random = new Random();

    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;
        map = new TreeMap<>();
        sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(sum, i);
        }
    }

    public int[] pick() {
        int c = map.ceilingKey(random.nextInt(sum) + 1);
        int[] rect = rects[map.get(c)];
        int left = rect[0], right = rect[2], bot = rect[1], top = rect[3];
        return new int[]{left + random.nextInt(right - left + 1), bot + random.nextInt(top - bot + 1)};
    }
}
