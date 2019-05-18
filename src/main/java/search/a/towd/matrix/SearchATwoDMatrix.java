package search.a.towd.matrix;

/**
 * @author hum
 */
public class SearchATwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)) {
            return false;
        }
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int row = right;
        if (row < 0) {
            return false;
        }
        System.out.println(row);
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
