package construct.k.palindrome.strings;

/**
 * @author hum
 */
public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        int[] tmp = new int[26];
        for (char c : s.toCharArray()) {
            tmp[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if ((tmp[i] & 1) != 0) {
                count++;
            }
        }
        return count <= k && k <= s.length();
    }
}
