package maximum.nesting.depth.of.the.parentheses;

/**
 * @author hum
 */
public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int cnt = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
                result = Math.max(result, cnt);
            } else if (c == ')') {
                cnt--;
            }
        }
        return result;
    }
}
