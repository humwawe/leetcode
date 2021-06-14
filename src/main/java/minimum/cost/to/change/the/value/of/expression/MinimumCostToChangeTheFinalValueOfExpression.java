package minimum.cost.to.change.the.value.of.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author hum
 */
public class MinimumCostToChangeTheFinalValueOfExpression {
    String expression;
    Map<Integer, Integer> map = new HashMap<>();

    public int minOperationsToFlip(String expression) {
        this.expression = expression;
        int len = expression.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.push(i);
            } else if (expression.charAt(i) == ')') {
                map.put(i, stack.pop());
            }
        }
        int[] res = helper(0, len - 1);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(int i, int j) {
        if (i == j) {
            if (expression.charAt(i) == '0') {
                return new int[]{0, 1};
            } else {
                return new int[]{1, 0};
            }
        }
        if (expression.charAt(j) == ')' && map.get(j) == i) {
            return helper(i + 1, j - 1);
        }
        int k = j - 1;
        if (expression.charAt(j) == ')') {
            k = map.get(j) - 1;
        }
        int[] res = new int[2];
        int[] tmp1 = helper(i, k - 1);
        int[] tmp2 = helper(k + 1, j);
        if (expression.charAt(k) == '&') {
            res[0] = Math.min(tmp1[0], tmp2[0]);
            res[1] = Math.min(tmp1[1] + tmp2[1], Math.min(tmp1[1], tmp2[1]) + 1);
        } else {
            res[0] = Math.min(tmp1[0] + tmp2[0], Math.min(tmp1[0], tmp2[0]) + 1);
            res[1] = Math.min(tmp1[1], tmp2[1]);
        }
        return res;
    }

    Stack<int[]> num = new Stack<>();
    Stack<Character> op = new Stack<>();

    public int minOperationsToFlip2(String expression) {
        for (char c : expression.toCharArray()) {
            if (c == '0') {
                num.push(new int[]{0, 1});
            } else if (c == '1') {
                num.push(new int[]{1, 0});
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                if (op.peek() != '(') {
                    eval();
                }
                op.pop();
            } else {
                if (!op.isEmpty() && op.peek() != '(') {
                    eval();
                }
                op.push(c);
            }
        }
        if (!op.isEmpty()) {
            eval();
        }
        return Math.max(num.peek()[0], num.peek()[1]);
    }

    private void eval() {
        int[] tmp2 = num.pop();
        int[] tmp1 = num.pop();
        char c = op.pop();
        int[] res = new int[2];
        if (c == '&') {
            res[0] = Math.min(tmp1[0], tmp2[0]);
            res[1] = Math.min(tmp1[1] + tmp2[1], Math.min(tmp1[1], tmp2[1]) + 1);
        } else {
            res[0] = Math.min(tmp1[0] + tmp2[0], Math.min(tmp1[0], tmp2[0]) + 1);
            res[1] = Math.min(tmp1[1], tmp2[1]);
        }
        num.push(res);
    }

}
