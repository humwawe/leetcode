package search.a.towd.matrix.II;

/**
 * @author hum
 */
public class SearchATwoDMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row - 1;
        int y = 0;
        while (x >= 0 && y < col) {
            int tmp = matrix[x][y];
            if (tmp == target) {
                return true;
            } else if (tmp > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
