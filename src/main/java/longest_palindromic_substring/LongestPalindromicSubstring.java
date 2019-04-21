package longest_palindromic_substring;

/**
 * @author hum
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int left, rihgt;
        int length = s.length();
        int max = 0;
        String result = "";
        //采用虚拟数组避免奇偶问题
        for (int index = 0; index < 2 * length - max; index++) {
            left = (index - 1) / 2;
            rihgt = index / 2;
            while (left >= 0 && rihgt < length) {
                if (s.charAt(left) == s.charAt(rihgt)) {
                    // 此处判断可以优化，在循环跳出去的时候在找substr
                    if (rihgt + 1 - left > max) {
                        max = rihgt + 1 - left;
                        result = s.substring(left, rihgt + 1);
                    }
                    left--;
                    rihgt++;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
