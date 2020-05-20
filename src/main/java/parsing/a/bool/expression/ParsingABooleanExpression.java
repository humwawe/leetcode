package parsing.a.bool.expression;

/**
 * @author hum
 */
public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        return helper(expression);
    }

    private boolean helper(String expression) {
        if (expression.indexOf(')') == -1) {
            return expression.equals("t");
        }
        int i = 0;
        int j = 0;
        for (int k = 0; k < expression.length(); k++) {
            if (expression.charAt(k) == ')') {
                j = k;
                break;
            }
            if (expression.charAt(k) == '(') {
                i = k;
            }
        }
        String[] split = expression.substring(i + 1, j).split(",");
        if (expression.charAt(i - 1) == '|') {
            String f = "f";
            for (String s : split) {
                if (s.equals("t")) {
                    f = "t";
                }
            }
            return helper(expression.substring(0, i - 1) + f + expression.substring(j + 1));
        } else if (expression.charAt(i - 1) == '&') {
            String f = "t";
            for (String s : split) {
                if (s.equals("f")) {
                    f = "f";
                }
            }
            return helper(expression.substring(0, i - 1) + f + expression.substring(j + 1));
        } else {
            String f = "f";
            if (split[0].equals("f")) {
                f = "t";
            }
            return helper(expression.substring(0, i - 1) + f + expression.substring(j + 1));
        }
    }
}
