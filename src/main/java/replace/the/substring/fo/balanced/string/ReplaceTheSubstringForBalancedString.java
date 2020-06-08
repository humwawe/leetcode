package replace.the.substring.fo.balanced.string;

/**
 * @author hum
 */
public class ReplaceTheSubstringForBalancedString {
    public int balancedString(String s) {
        int len = s.length();
        int[] count = new int[4];
        char[] cs = new char[]{'Q', 'W', 'E', 'R'};
        int[] tmp = new int[26];
        for (char c : s.toCharArray()) {
            tmp[c - 'A']++;
        }
        boolean f = true;
        for (int i = 0; i < 4; i++) {
            count[i] = tmp[cs[i] - 'A'] - len / 4;
            if (count[i] != 0) {
                f = false;
            }
        }
        if (f) {
            return 0;
        }
        int j = 0;
        int[] t = new int[26];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            t[s.charAt(i) - 'A']++;
            while (j <= i && helper(t, cs, count)) {
                result = Math.min(result, i - j + 1);
                t[s.charAt(j) - 'A']--;
                j++;
            }
        }
        return result;
    }

    private boolean helper(int[] t, char[] cs, int[] c) {
        for (int i = 0; i < 4; i++) {
            if (t[cs[i] - 'A'] < c[i]) {
                return false;
            }
        }
        return true;
    }
}
