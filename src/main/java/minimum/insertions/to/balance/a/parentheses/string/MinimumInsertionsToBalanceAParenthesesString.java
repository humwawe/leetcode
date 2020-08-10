package minimum.insertions.to.balance.a.parentheses.string;

import java.util.Stack;

/**
 * @author hum
 */
public class MinimumInsertionsToBalanceAParenthesesString {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.isEmpty()) {
                    st.push('(');
                    cnt++;
                }
                if (i == s.length() - 1 || s.charAt(i + 1) != ')') {
                    cnt++;
                    st.pop();
                } else {
                    i++;
                    st.pop();
                }
            }
        }
        return cnt + st.size() * 2;
    }
}
