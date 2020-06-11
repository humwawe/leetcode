package reconstruct.a.two.row.binary.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class ReconstructA2RowBinaryMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        int len = colsum.length;
        int u = len - upper;
        int l = lower;
        for (int i = 0; i < len; i++) {
            if (colsum[i] == 2) {
                if (u > 0 && l > 0) {
                    res1.add(1);
                    res2.add(1);
                    u--;
                    l--;
                } else {
                    return new ArrayList<>();
                }
            } else if (colsum[i] == 0) {
                res1.add(0);
                res2.add(0);
            } else if (colsum[i] == 1) {
                if (u == 0 && l == 0) {
                    return new ArrayList<>();
                } else if (u >= l) {
                    res1.add(1);
                    res2.add(0);
                    u--;
                } else {
                    res1.add(0);
                    res2.add(1);
                    l--;
                }
            }
        }
        if (u != 0 || l != 0) {
            return new ArrayList<>();
        }
        result.add(res1);
        result.add(res2);
        return result;
    }
}
