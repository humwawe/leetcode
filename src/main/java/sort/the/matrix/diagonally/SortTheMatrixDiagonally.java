package sort.the.matrix.diagonally;

import java.util.*;

/**
 * @author hum
 */
public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!map.containsKey(i - j)) {
                    map.put(i - j, new ArrayList<>());
                }
                map.get(i - j).add(mat[i][j]);
            }
        }
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = map.get(i - j).get(0);
                map.get(i - j).remove(0);
            }
        }
        return result;
    }
}
