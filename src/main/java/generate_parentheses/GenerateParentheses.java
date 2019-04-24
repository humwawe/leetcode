package generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        int left = n, right = n;
        List<String> results = new ArrayList<>();
        helper("", left, right, results);
        return results;
    }

    private void helper(String s, int left, int right, List<String> results) {

        if (left > 0) {
            helper(s + "(", left - 1, right, results);
        }
        if (left < right) {
            helper(s + ")", left, right - 1, results);
        }
        if (left == 0 && right == 0) {
            results.add(s);
        }
    }


}
