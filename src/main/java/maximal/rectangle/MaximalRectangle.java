package maximal.rectangle;


/**
 * @author hum
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int lastJ = col;
                    int tmpI = i;
                    while (tmpI < row && matrix[tmpI][j] == '1') {
                        int tmpJ = j;
                        while (tmpJ < lastJ && matrix[tmpI][tmpJ] == '1') {
                            tmpJ++;
                        }
                        result = Math.max(result, (tmpJ - j) * (tmpI - i + 1));
                        lastJ = tmpJ;
                        tmpI++;
                    }
                }
            }
        }
        return result;
    }
}
