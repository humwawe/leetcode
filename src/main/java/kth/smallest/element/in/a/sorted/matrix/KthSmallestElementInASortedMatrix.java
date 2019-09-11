package kth.smallest.element.in.a.sorted.matrix;

/**
 * @author hum
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int left = matrix[0][0], right = matrix[row - 1][col - 1];
        while (left <= right) {
            int cnt = 0, mid = left + (right - left) / 2;
            int i = row - 1, j = 0;
            while (i >= 0 && j < col) {
                if (matrix[i][j] <= mid) {
                    cnt += i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
