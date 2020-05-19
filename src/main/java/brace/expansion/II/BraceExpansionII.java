package brace.expansion.II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class BraceExpansionII {
    public List<String> braceExpansionII(String expression) {
        List<String> result = new ArrayList<>(helper(expression));
        result.sort(String::compareTo);
        return result;
    }

    private Set<String> helper(String expression) {
        Set<String> res = new HashSet<>();
        if (expression.indexOf('}') == -1) {
            res.add(expression);
            return res;
        }
        int i = 0;
        int j = 0;
        for (int k = 0; k < expression.length(); k++) {
            if (expression.charAt(k) == '}') {
                j = k;
                break;
            }
            if (expression.charAt(k) == '{') {
                i = k;
            }
        }
        String[] substrings = expression.substring(i + 1, j).split(",");
        for (String substring : substrings) {
            Set<String> tmp = helper(expression.substring(0, i) + substring + expression.substring(j + 1));
            res.addAll(tmp);
        }
        return res;
    }
}
