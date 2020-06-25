package find.the.kth.smallest.sum.of.a.matrix.with.sorted.rows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class FindTheKthSmallestSumOfAMatrixWithSortedRows {
    public int kthSmallest(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < row; i++) {
            List<Integer> res = new ArrayList<>();
            for (Integer integer : list) {
                for (int j = 0; j < Math.min(col, k); j++) {
                    res.add(integer + mat[i][j]);
                }
            }
            Collections.sort(res);
            if (res.size() <= k) {
                list = res;
            } else {
                list = res.subList(0, k);
            }
        }
        return list.get(list.size() - 1);
    }
}
