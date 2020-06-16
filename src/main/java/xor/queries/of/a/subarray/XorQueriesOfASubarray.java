package xor.queries.of.a.subarray;

/**
 * @author hum
 */
public class XorQueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] t = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            t[i] = t[i - 1] ^ arr[i - 1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = t[queries[i][1] + 1] ^ t[queries[i][0]];
        }
        return result;
    }
}
