package longest.palindrome.by.concatenating.two.letter.words;

/**
 * @author hum
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        int[][] arr = new int[26][26];
        int len = 0;
        for (String word : words) {
            int x = word.charAt(0) - 'a';
            int y = word.charAt(1) - 'a';
            if (arr[y][x] > 0) {
                arr[y][x]--;
                len += 4;
            } else {
                arr[x][y]++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][i] > 0) {
                len += 2;
                break;
            }
        }
        return len;
    }
}
