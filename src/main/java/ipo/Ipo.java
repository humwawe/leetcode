package ipo;

import java.util.PriorityQueue;


/**
 * @author hum
 */
public class Ipo {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (profits.length < 1) {
            return w;
        }
        PriorityQueue<int[]> p1 = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> p2 = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < profits.length; ++i) {
            p1.offer(new int[]{capital[i], profits[i]});
        }
        while (k-- != 0) {
            while (!p1.isEmpty() && p1.peek()[0] <= w) {
                p2.offer(p1.poll());
            }
            if (p2.isEmpty()) {
                break;
            }
            w += p2.poll()[1];
        }
        return w;
    }

}
