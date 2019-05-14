package spiral.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return result;
        }
        int col = matrix[0].length;
        result.add(matrix[0][0]);

        int indexX = 0, indexY = 0;

        for (int i = 0; i < (Math.min(row, col) + 1) / 2; i++) {
            while (indexY < col - i - 1) {
                result.add(matrix[indexX][++indexY]);
            }
            if (result.size() == col * row) {
                break;
            }
            while (indexX < row - i - 1) {
                result.add(matrix[++indexX][indexY]);
            }
            if (result.size() == col * row) {
                break;
            }

            while (indexY > i) {
                result.add(matrix[indexX][--indexY]);
            }
            if (result.size() == col * row) {
                break;
            }

            while (indexX > i + 1) {
                result.add(matrix[--indexX][indexY]);

            }
            if (result.size() == col * row) {
                break;
            }
        }
        return result;
    }
}
