package baseball.game;

import java.util.Stack;

/**
 * @author hum
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (String op : ops) {
            switch (op) {
                case "C": {
                    int tmp = stack.pop();
                    result -= tmp;
                    break;
                }
                case "D": {
                    int tmp = stack.peek() * 2;
                    result += tmp;
                    stack.push(tmp);
                    break;
                }
                case "+": {
                    int tmp = stack.pop();
                    int tmp2 = stack.peek();
                    result += tmp + tmp2;
                    stack.push(tmp);
                    stack.push(tmp + tmp2);
                    break;
                }
                default:
                    result += Integer.valueOf(op);
                    stack.push(Integer.valueOf(op));
                    break;
            }
        }
        return result;
    }
}
