package lexicographically.smallest.string.after.applying.operations;

/**
 * @author hum
 */
public class LexicographicallySmallestStringAfterApplyingOperations {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        char[] chs = s.toCharArray();
        String res = s;
        if (b % 2 == 0) {
            for (int i = 0; i < 10; i++) {
                for (int j = 1; j < n; j += 2) {
                    update(chs, j, a);
                }
                res = getString(b, n, chs, res);
            }
            return res;
        } else {
            for (int i = 0; i < 10; i++) {
                for (int j = 1; j < n; j += 2) {
                    update(chs, j, a);
                }
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < n; k += 2) {
                        update(chs, k, a);
                    }
                    res = getString(b, n, chs, res);
                }
            }
        }
        return res;
    }

    private String getString(int b, int n, char[] chs, String res) {
        String temp = new String(chs);
        for (int k = 0; k < n; k++) {
            temp = temp.substring(n - b) + temp.substring(0, n - b);
            if (res.compareTo(temp) > 0) {
                res = temp;
            }
        }
        return res;
    }

    private void update(char[] chs, int i, int a) {
        int digit = chs[i] - '0';
        chs[i] = (char) ('0' + (digit + a) % 10);
    }
}
