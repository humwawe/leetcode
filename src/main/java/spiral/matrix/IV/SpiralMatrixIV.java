package spiral.matrix.IV;

import common.ListNode;

import java.util.Arrays;

/**
 * @author PF-2CRL0N
 */
public class SpiralMatrixIV {
  public int[][] spiralMatrix(int m, int n, ListNode head) {
    int[][] res = new int[m][n];
    for (int[] r : res) {
      Arrays.fill(r, -1);
    }
    int x = 0, y = 0;
    int[][] fs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int i = 0;
    while (head != null) {
      res[x][y] = head.val;
      head = head.next;
      int nx = x + fs[i][0];
      int ny = y + fs[i][1];
      if (nx < 0 || ny < 0 || nx >= m || ny >= n || res[nx][ny] != -1) {
        i = (i + 1) % 4;
        nx = x + fs[i][0];
        ny = y + fs[i][1];
      }
      x = nx;
      y = ny;
    }
    return res;
  }
}
