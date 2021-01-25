package find.kth.largest.xor.coordinate.value;

import java.util.Arrays;

/**
 * @author hum
 */
public class FindKthLargestXorCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] a = new int[row * col];
        int[][] arr = new int[row + 1][col + 1];
        int idx = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                arr[i][j] = arr[i - 1][j] ^ arr[i][j - 1] ^ arr[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                a[idx++] = arr[i][j];
            }
        }
        Arrays.sort(a);
        return a[row * col - k];
    }
}
