package diagonal.traverse;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int x = 0, y = 0;
        int i = 0;
        boolean flag = true;
        while (x != row - 1 || y != col - 1) {
            result[i++] = matrix[x][y];
            if (flag) {
                x -= 1;
                y += 1;
                if (x == -1 && y < col) {
                    x = 0;
                    flag = false;
                } else if (y == col) {
                    x += 2;
                    y -= 1;
                    flag = false;
                }
            } else {
                x += 1;
                y -= 1;
                if (y == -1 && x < row) {
                    y = 0;
                    flag = true;
                } else if (y == col) {
                    y += 2;
                    x -= 1;
                    flag = true;
                }
            }
        }
        result[i] = matrix[row - 1][col - 1];
        return result;
    }
}
