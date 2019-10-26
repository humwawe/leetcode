package unique.substrings.in.wraparound.strings;

/**
 * @author hum
 */
public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int len = p.length();
        if (len == 0) {
            return 0;
        }
        int[] res = new int[26];
        int prev = 1;
        res[p.charAt(0) - 'a'] = 1;
        for (int i = 1; i < len; i++) {
            int cur = p.charAt(i) - 'a';
            int last = p.charAt(i - 1) - 'a';
            if (cur % 26 == (last + 1) % 26) {
                res[cur] = Math.max(res[cur], prev + 1);
                prev = prev + 1;
            } else {
                res[cur] = Math.max(res[cur], 1);
                prev = 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += res[i];
        }
        return result;
    }
}
