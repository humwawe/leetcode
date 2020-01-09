package parse.lisp.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class ParseLispExpression {
    public int evaluate(String expression) {
        return helper(expression, new HashMap<>());
    }

    private int helper(String expr, Map<String, Integer> map) {
        if (isNumber(expr)) {
            return Integer.valueOf(expr);
        }
        if (isVar(expr)) {
            return map.get(expr);
        }
        List<String> list = parse(expr);
        if ("add".equals(list.get(0))) {
            return helper(list.get(1), map) + helper(list.get(2), map);
        } else if ("mult".equals(list.get(0))) {
            return helper(list.get(1), map) * helper(list.get(2), map);
        } else {
            Map<String, Integer> newMap = new HashMap<>(map);
            for (int i = 1; i < list.size() - 1; i += 2) {
                newMap.put(list.get(i), helper(list.get(i + 1), newMap));
            }
            return helper(list.get(list.size() - 1), newMap);
        }

    }

    private boolean isNumber(String expr) {
        char c = expr.charAt(0);
        return c >= '0' && c <= '9' || c == '-';
    }

    private boolean isVar(String expr) {
        char c = expr.charAt(0);
        return c >= 'a' && c <= 'z';
    }

    private List<String> parse(String expr) {
        expr = expr.substring(1, expr.length() - 1);
        List<String> res = new ArrayList<>();
        int start = 0;
        while (start < expr.length()) {
            int end = next(expr, start);
            res.add(expr.substring(start, end));
            start = end + 1;
        }
        return res;
    }

    private int next(String expr, int start) {
        int index = start;
        if (expr.charAt(index) == '(') {
            int count = 1;
            index++;
            while (index < expr.length() && count > 0) {
                if (expr.charAt(index) == '(') {
                    count++;
                } else if (expr.charAt(index) == ')') {
                    count--;
                }
                index++;
            }
        } else {
            while (index < expr.length() && expr.charAt(index) != ' ') {
                index++;
            }
        }
        return index;
    }
}
