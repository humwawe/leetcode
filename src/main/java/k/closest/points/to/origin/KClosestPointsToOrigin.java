package k.closest.points.to.origin;


import java.util.PriorityQueue;

/**
 * @author hum
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] point : points) {
            queue.add(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            result[i] = poll;
            i++;
        }
        return result;
    }
}
