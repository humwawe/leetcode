package longest.substring.of.all.vowels.in.order;

/**
 * @author hum
 */
public class LongestSubstringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        int ans = 0, type = 1, len = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= word.charAt(i - 1)) {
                len++;
            }
            if (word.charAt(i) > word.charAt(i - 1)) {
                type++;
            }
            if (word.charAt(i) < word.charAt(i - 1)) {
                type = 1;
                len = 1;
            }
            if (type == 5) {
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
