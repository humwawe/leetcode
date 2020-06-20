package design.a.stack.with.increment.operation;

/**
 * @author hum
 */
public class DesignAStackWithIncrementOperation {
    int[] st = new int[1005];
    int maxSize;
    int index;

    public DesignAStackWithIncrementOperation(int maxSize) {
        this.maxSize = maxSize;
        index = 0;
    }

    public void push(int x) {
        if (index >= maxSize) {
            return;
        }
        st[index++] = x;
    }

    public int pop() {
        if (index == 0) {
            return -1;
        }
        return st[--index];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, index); i++) {
            st[i] += val;
        }
    }
}
