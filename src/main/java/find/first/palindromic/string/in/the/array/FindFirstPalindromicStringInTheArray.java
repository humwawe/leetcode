package find.first.palindromic.string.in.the.array;

/**
 * @author hum
 */
public class FindFirstPalindromicStringInTheArray {
    public String firstPalindrome(String[] words) {
        f:
        for (String word : words) {
            for (int i = 0; i < word.length() / 2; i++) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    continue f;
                }
            }
            return word;
        }
        return "";
    }
}
