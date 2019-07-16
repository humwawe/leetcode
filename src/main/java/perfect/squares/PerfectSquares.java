package perfect.squares;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class PerfectSquares {
    public int numSquares(int n) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[n + 1];
        for (int i = 1; i * i <= n; i++) {
            queue.offer(new Node(i * i, i * i));
            visit[i * i] = true;
        }
        int result = 0;
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tmp = queue.poll();
                if (tmp.sum == n) {
                    found = true;
                    break;
                }
                for (int j = 1; j * j <= n - tmp.sum; j++) {
                    if (!visit[tmp.sum + j * j]) {
                        queue.offer(new Node(j * j, tmp.sum + j * j));
                        visit[tmp.sum + j * j] = true;
                    }

                }
            }
            result++;
        }

        return result;
    }

    class Node {
        public int num;
        public int sum;

        public Node(int num, int sum) {
            this.num = num;
            this.sum = sum;
        }
    }
}
