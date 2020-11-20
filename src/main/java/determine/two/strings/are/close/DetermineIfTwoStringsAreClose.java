package determine.two.strings.are.close;

import java.util.Arrays;

/**
 * @author hum
 */
public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char c : word1.toCharArray()) {
            cnt1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            cnt2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != 0 && cnt2[i] == 0 || cnt1[i] == 0 && cnt2[i] != 0) {
                return false;
            }
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }
}
