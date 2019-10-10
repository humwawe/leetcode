package common;

/**
 * @author hum
 */
public class MultiDoublyNode {
    public int val;
    public MultiDoublyNode prev;
    public MultiDoublyNode next;
    public MultiDoublyNode child;

    public MultiDoublyNode() {
    }

    public MultiDoublyNode(int val, MultiDoublyNode prev, MultiDoublyNode next, MultiDoublyNode child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
