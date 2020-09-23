package strange.printer.II;

import java.util.*;

/**
 * @author hum
 */
public class StrangePrinterII {
    public boolean isPrintable(int[][] targetGrid) {
        int n = targetGrid.length;
        int m = targetGrid[0].length;

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int color = targetGrid[i][j];
                if (!map.containsKey(color)) {
                    map.put(color, new Node(j, j, i, i));
                } else {
                    Node node = map.get(color);
                    node.left = Math.min(node.left, j);
                    node.right = Math.max(node.right, j);
                    node.up = Math.min(node.up, i);
                    node.down = Math.max(node.down, i);
                }
            }
        }

        LinkedList<Node> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        for (Integer color : map.keySet()) {
            Node node = map.get(color);
            if (check(targetGrid, node, color)) {
                q.addLast(node);
                vis.add(color);
            }
        }
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            setZero(targetGrid, now);
            for (Map.Entry<Integer, Node> entry : map.entrySet()) {
                int color = entry.getKey();
                Node node = entry.getValue();
                if (!vis.contains(color) && check(targetGrid, node, color)) {
                    q.addLast(node);
                    vis.add(color);
                }
            }
        }
        return check(targetGrid, new Node(0, m - 1, 0, n - 1), 0);
    }

    private boolean check(int[][] mat, Node node, int color) {
        for (int i = node.up; i <= node.down; i++) {
            for (int j = node.left; j <= node.right; j++) {
                if (mat[i][j] != 0 && mat[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    private void setZero(int[][] mat, Node node) {
        for (int i = node.up; i <= node.down; i++) {
            for (int j = node.left; j <= node.right; j++) {
                mat[i][j] = 0;
            }
        }
    }

    private class Node {
        int left, right;
        int up, down;

        Node(int l, int r, int u, int d) {
            left = l;
            right = r;
            up = u;
            down = d;
        }
    }
}
