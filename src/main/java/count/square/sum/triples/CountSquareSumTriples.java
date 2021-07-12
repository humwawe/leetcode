package count.square.sum.triples;

/**
 * @author hum
 */
public class CountSquareSumTriples {
    public int countTriples(int n) {
        boolean[] st = new boolean[n * n + 1];
        for (int i = 1; i <= n; i++) {
            st[i * i] = true;
        }

        int res = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if ((i * i) + (j * j) <= n * n && st[(i * i) + (j * j)]) {
                    res += 2;
                }
            }
        }
        return res;
    }
}
