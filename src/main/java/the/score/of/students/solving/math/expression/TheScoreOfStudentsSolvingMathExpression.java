package the.score.of.students.solving.math.expression;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author hum
 */
public class TheScoreOfStudentsSolvingMathExpression {
    Set<Integer>[][] memo = new Set[32][32];

    public int scoreOfStudents(String s, int[] answers) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                Integer num1 = stack.pop();
                Integer num2 = s.charAt(i + 1) - '0';
                stack.push(num1 * num2);
                i++;
            } else if (Character.isDigit(s.charAt(i))) {
                stack.push(s.charAt(i) - '0');
            }
        }
        int q = 0;
        while (!stack.isEmpty()) {
            q += stack.pop();
        }

        Set<Integer> set = dfs(s, 0, s.length() - 1);
        int res = 0;
        for (int answer : answers) {
            if (answer == q) {
                res += 5;
            } else if (set.contains(answer)) {
                res += 2;
            }
        }
        return res;
    }

    private Set<Integer> dfs(String s, int i, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        Set<Integer> set = new HashSet<>();
        if (i == j) {
            set.add(s.charAt(i) - '0');
            return set;
        }

        for (int k = i; k <= j; k++) {
            if (!Character.isDigit(s.charAt(k))) {
                Set<Integer> left = dfs(s, i, k - 1);
                Set<Integer> right = dfs(s, k + 1, j);
                for (Integer l : left) {
                    for (Integer r : right) {
                        if (s.charAt(k) == '+') {
                            if (l + r <= 1000) {
                                set.add(l + r);
                            }
                        } else {
                            if (l * r <= 1000) {
                                set.add(l * r);
                            }
                        }
                    }
                }
            }
        }
        return memo[i][j] = set;
    }
}
