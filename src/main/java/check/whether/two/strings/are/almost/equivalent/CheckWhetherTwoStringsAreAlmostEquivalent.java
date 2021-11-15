package check.whether.two.strings.are.almost.equivalent;

/**
 * @author hum
 */
public class CheckWhetherTwoStringsAreAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char c : word1.toCharArray()) {
            cnt1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            cnt2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(cnt1[i] - cnt2[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}
