package longest.valid.parentheses;


/**
 * @author hum
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int a = helper(s, '(');
        int b = helper(new StringBuilder(s).reverse().toString(), ')');
        return a > b ? a : b;
    }

    private int helper(String s, char leftParentheses) {
        int num = 0, count = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == leftParentheses) {
                num++;
            } else {
                if (--num < 0) {
                    count = 0;
                    num = 0;
                } else {
                    count += 2;
                    if (num == 0) {
                        result = Math.max(result, count);
                    }
                }
            }
        }
        return result;
    }


}
