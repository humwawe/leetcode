package furthest.building.you.can.reach;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int len = heights.length;
        int sum = 0;
        int res = 0;
        for (int i = 1; i < len; i++) {
            int t = heights[i] - heights[i - 1];
            if (t > 0) {
                priorityQueue.add(t);
            }
            if (priorityQueue.size() > ladders) {
                sum += priorityQueue.poll();
            }
            if (sum > bricks) {
                return res;
            }
            res = Math.max(res, i);
        }
        return res;
    }
}
