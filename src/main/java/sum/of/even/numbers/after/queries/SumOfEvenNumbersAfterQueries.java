package sum.of.even.numbers.after.queries;

/**
 * @author hum
 */
public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] a, int[][] queries) {
        int len = queries.length;
        int res = 0;
        for (int i : a) {
            if (i % 2 == 0) {
                res += i;
            }
        }
        int[] result = new int[len];
        for (int i = 0; i < queries.length; i++) {
            if (a[queries[i][1]] % 2 == 0) {
                if (queries[i][0] % 2 == 0) {
                    res += queries[i][0];
                } else {
                    res -= a[queries[i][1]];
                }
                a[queries[i][1]] += queries[i][0];
            } else {
                if (queries[i][0] % 2 != 0) {
                    a[queries[i][1]] += queries[i][0];
                    res += a[queries[i][1]];
                } else {
                    a[queries[i][1]] += queries[i][0];
                }
            }
            result[i] = res;
        }
        return result;
    }
}
