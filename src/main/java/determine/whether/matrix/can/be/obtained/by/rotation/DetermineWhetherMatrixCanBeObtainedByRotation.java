package determine.whether.matrix.can.be.obtained.by.rotation;

import java.util.Arrays;

/**
 * @author hum
 */
public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        int[][] tmp = mat;
        for (int i = 0; i < 4; i++) {
            tmp = change(tmp);
            if (Arrays.deepEquals(tmp, target)) {
                return true;
            }
        }
        return false;
    }

    public static int[][] change(int[][] matrix) {
        int[][] temp = new int[matrix[0].length][matrix.length];
        int dst = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++, dst--) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][dst] = matrix[i][j];
            }
        }
        return temp;
    }
}
