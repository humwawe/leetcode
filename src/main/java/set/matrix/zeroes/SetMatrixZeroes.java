package set.matrix.zeroes;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet();
        Set<Integer> col = new HashSet();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (row.contains(i)) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            } else {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (col.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
