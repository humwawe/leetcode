package restore.the.array;

/**
 * @author hum
 */
public class RestoreTheArray {
    String s;
    int k;
    int mod = (int) (1e9 + 7);
    Integer[] memo = new Integer[(int) (1e5 + 5)];

    public int numberOfArrays(String s, int k) {
        this.s = s;
        this.k = k;
        return helper(0);
    }

    private int helper(int i) {
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        long res = 0;
        long sum = 0;
        for (int j = i; j < s.length(); j++) {
            sum = sum * 10 + s.charAt(j) - '0';
            if (sum > k) {
                break;
            }
            res += helper(j + 1);
            res %= mod;
        }
        return memo[i] = (int) (res %= mod);
    }
}
