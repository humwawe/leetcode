package longest.palindrome;

/**
 * @author hum
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] tmp = new int[60];
        for (char c : s.toCharArray()) {
            tmp[c - 'A']++;
        }

        boolean flag = false;
        int result = 0;
        for (int i = 0; i < 60; i++) {
            if (tmp[i] % 2 != 0) {
                flag = true;
            }
            result += tmp[i] / 2 * 2;
        }
        return flag ? result + 1 : result;
    }
}
