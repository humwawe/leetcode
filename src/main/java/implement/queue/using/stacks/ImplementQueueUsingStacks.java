package implement.queue.using.stacks;

import java.util.Stack;

/**
 * @author hum
 */
public class ImplementQueueUsingStacks {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    public void push(int x) {
        stack1.push(x);
    }


    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }


    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
