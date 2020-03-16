package online.stock.span;

import java.util.Stack;

/**
 * @author hum
 */
public class OnlineStockSpan {
    Stack<int[]> stack;

    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && price > stack.peek()[0]) {
            count += stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, count});
        return count;
    }
}
