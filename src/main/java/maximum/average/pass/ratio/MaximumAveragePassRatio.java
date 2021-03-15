package maximum.average.pass.ratio;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(x -> x.z));
        for (int[] aClass : classes) {
            priorityQueue.add(new Node(aClass[0], aClass[1], (double) aClass[0] / aClass[1]));
        }
        while (extraStudents-- > 0) {
            Node cur = priorityQueue.poll();
            cur.x++;
            cur.y++;
            cur.z = (double) cur.x / cur.y - (double) (cur.x + 1) / (cur.y + 1);
            priorityQueue.add(cur);
        }
        double res = 0;
        while (!priorityQueue.isEmpty()) {
            Node cur = priorityQueue.poll();
            res += (double) cur.x / cur.y;
        }
        return res / classes.length;
    }

    class Node {
        int x, y;
        double z;

        public Node(int x, int y, double z) {
            this.x = x;
            this.y = y;
            this.z = (double) x / y - (double) (x + 1) / (y + 1);

        }
    }
}
