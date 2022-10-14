package using.a.robot.to.print.the.lexicographically.smallest.string;

import java.util.Stack;

/**
 * @author hum
 */
public class UsingARobotToPrintTheLexicographicallySmallestString {
  public String robotWithString(String s) {
    StringBuilder sb = new StringBuilder();
    Stack<Character> st = new Stack<>();
    int len = s.length();
    int[] helper = new int[len + 1];
    helper[len] = (int) ('z' - 'a' + 1);
    for (int i = len - 1; i >= 0; i--) {
      helper[i] = Math.min(helper[i + 1], s.charAt(i) - 'a');
    }
    for (int i = 0; i < len; i++) {
      st.push(s.charAt(i));
      while (!st.isEmpty() && (st.peek() - 'a') <= helper[i + 1]) {
        sb.append(st.pop());
      }
    }
    return sb.toString();
  }
}
