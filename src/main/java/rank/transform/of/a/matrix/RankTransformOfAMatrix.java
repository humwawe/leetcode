package rank.transform.of.a.matrix;

import java.util.*;

/**
 * @author hum
 */
public class RankTransformOfAMatrix {
    public int[][] matrixRankTransform(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        int[] r = new int[row];
        int[] c = new int[col];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                queue.offer(new int[]{matrix[i][j], i, j});
            }
        }
        while (!queue.isEmpty()) {
            int target = queue.peek()[0];
            List<int[]> list = new ArrayList<>();
            while (!queue.isEmpty() && queue.peek()[0] == target) {
                list.add(queue.poll());
            }
            UF uf = new UF(row + col);
            for (int[] pair : list) {
                uf.union(pair[1], pair[2] + row);
            }
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int[] pair : list) {
                map.computeIfAbsent(uf.find(pair[1]), x -> new ArrayList<>()).add(pair);
            }
            for (List<int[]> group : map.values()) {
                int rank = 0;
                for (int[] arr : group) {
                    int i = arr[1];
                    int j = arr[2];
                    rank = Math.max(rank, Math.max(r[i], c[j]) + 1);
                }
                for (int[] arr : group) {
                    int i = arr[1];
                    int j = arr[2];
                    res[i][j] = rank;
                    r[i] = Math.max(r[i], rank);
                    c[j] = Math.max(c[j], rank);
                }
            }
        }
        return res;
    }

    class UF {
        UF(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        private int[] parent;

        private int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        private void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
