package swap.fo.longest.repeated.character.substring;

/**
 * @author hum
 */
public class SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            int cnt = 0;
            int l = 0;
            for (int j = 0; j < text.length(); j++) {
                int c = text.charAt(j) - 'a';
                if (c != i) {
                    cnt++;
                }
                while (l < j && cnt > 1) {
                    if (text.charAt(l) - 'a' != i) {
                        cnt--;
                    }
                    l++;
                }
                result = Math.max(result, Math.min(j - l + 1, count[i]));
            }
        }
        return result;
    }
}
