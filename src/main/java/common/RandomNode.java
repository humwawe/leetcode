package common;

/**
 * @author hum
 */
public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode() {
    }

    public RandomNode(int val, RandomNode next, RandomNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
