package minimum.add.to.make.parentheses.valid;

/**
 * @author hum
 */
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (count == 0) {
                    result++;
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }
        return result + count;
    }
}
