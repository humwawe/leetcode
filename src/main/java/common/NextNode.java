package common;

/**
 * @author hum
 */
public class NextNode {
    public int val;
    public NextNode left;
    public NextNode right;
    public NextNode next;

    public NextNode() {
    }

    public NextNode(int val, NextNode left, NextNode right, NextNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}