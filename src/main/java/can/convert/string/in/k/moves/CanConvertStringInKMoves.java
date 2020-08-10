package can.convert.string.in.k.moves;

/**
 * @author hum
 */
public class CanConvertStringInKMoves {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        int[] a = new int[len];
        int[] cnt = new int[26];
        for (int i = 0; i < len; i++) {
            a[i] = t.charAt(i) - s.charAt(i);
            if (a[i] < 0) {
                a[i] += 26;
            }
            if (a[i] != 0) {
                cnt[a[i]]++;
            }

        }

        for (int i = 0; i < 26; i++) {
            if (i + (cnt[i] - 1) * 26 > k) {
                return false;
            }
        }
        return true;
    }
}
