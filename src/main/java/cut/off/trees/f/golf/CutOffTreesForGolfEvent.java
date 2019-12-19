package cut.off.trees.f.golf;

import java.util.*;

/**
 * @author hum
 */
public class CutOffTreesForGolfEvent {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int cutOffTree(List<List<Integer>> forest) {
        int row = forest.size();
        int col = forest.get(0).size();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (forest.get(i).get(j) > 1) {
                    priorityQueue.add(new Node(forest.get(i).get(j), i, j));
                }
            }
        }
        int x = 0;
        int y = 0;
        int result = 0;

        while (!priorityQueue.isEmpty()) {
            Node poll = priorityQueue.poll();
            int t = helper(forest, x, y, poll.x, poll.y);
            if (t != -1) {
                result += t;
            } else {
                return -1;
            }
            x = poll.x;
            y = poll.y;
        }
        return result;
    }

    private int helper(List<List<Integer>> forest, int x, int y, int x1, int y1) {
        Queue<int[]> queue = new ArrayDeque<>();
        int row = forest.size();
        int col = forest.get(0).size();
        boolean[][] vis = new boolean[row][col];
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        queue.add(new int[]{x, y});
        vis[x][y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == x1 && poll[1] == y1) {
                    return count;
                }
                for (int[] f : fs) {
                    int newX = poll[0] + f[0];
                    int newY = poll[1] + f[1];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col && !vis[newX][newY] && forest.get(newX).get(newY) != 0) {
                        vis[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            count++;
        }
        return -1;
    }

    class Node {
        int val;
        int x;
        int y;

        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
}
