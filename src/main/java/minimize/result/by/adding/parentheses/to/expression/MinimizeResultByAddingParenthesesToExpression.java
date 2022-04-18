package minimize.result.by.adding.parentheses.to.expression;

/**
 * @author hum
 */
public class MinimizeResultByAddingParenthesesToExpression {
  public String minimizeResult(String expression) {
    String[] s = expression.split("\\+");
    int len1 = s[0].length();
    int len2 = s[1].length();
    long res = Long.MAX_VALUE;
    int x = 0;
    int y = 0;
    for (int i = 0; i < len1; i++) {
      long a = s[0].substring(0, i).isEmpty() ? 0 : Long.parseLong(s[0].substring(0, i));
      long b = Long.parseLong(s[0].substring(i));
      for (int j = 0; j < len2; j++) {
        long c = Long.parseLong(s[1].substring(0, j + 1));
        long d = s[1].substring(j + 1).isEmpty() ? 0 : Long.parseLong(s[1].substring(j + 1));
        long t = b + c;
        if (a != 0) {
          t *= a;
        }
        if (d != 0) {
          t *= d;
        }
        if (res > t) {
          res = t;
          x = i;
          y = j;
        }
      }
    }

    StringBuilder sb = new StringBuilder(expression);
    sb.insert(s[0].length() + 2 + y, ")");
    sb.insert(x, "(");
    return sb.toString();
  }
}
