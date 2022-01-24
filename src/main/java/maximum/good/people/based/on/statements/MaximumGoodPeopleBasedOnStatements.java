package maximum.good.people.based.on.statements;

/**
 * @author hum
 */
public class MaximumGoodPeopleBasedOnStatements {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int lim = 1 << n;
        int res = 0;
        for (int i = 1; i < lim; i++) {
            boolean f = true;
            l:
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    for (int k = 0; k < statements[j].length; k++) {
                        if (statements[j][k] < 2 && statements[j][k] != ((i >> k) & 1)) {
                            f = false;
                            break l;
                        }
                    }
                }
            }
            if (f) {
                res = Math.max(res, Integer.bitCount(i));
            }
        }
        return res;
    }
}
