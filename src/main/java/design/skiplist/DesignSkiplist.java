package design.skiplist;

import java.util.Random;

/**
 * @author hum
 */
public class DesignSkiplist {
    Node head;
    Node[] levels;

    public DesignSkiplist() {
        head = new Node(-1, null, null);
        levels = new Node[64];
    }

    public boolean search(int target) {
        for (Node node = head; node != null; node = node.down) {
            while (node.right != null && node.right.val < target) {
                node = node.right;
            }
            if (node.right != null && node.right.val == target) {
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        int level = -1;
        for (Node node = head; node != null; node = node.down) {
            while (node.right != null && node.right.val < num) {
                node = node.right;
            }
            levels[++level] = node;
        }
        boolean isInsertUpwards = true;
        Node downNode = null;
        while (isInsertUpwards && level >= 0) {
            Node pre = levels[level--];
            pre.right = new Node(num, pre.right, downNode);
            downNode = pre.right;
            isInsertUpwards = (new Random().nextInt() & 1) == 0;
        }
        if (isInsertUpwards) {
            head = new Node(-1, new Node(num, null, downNode), head);
        }
    }

    public boolean erase(int num) {
        boolean res = false;
        for (Node node = head; node != null; node = node.down) {
            while (node.right != null && node.right.val < num) {
                node = node.right;
            }
            if (node.right != null && node.right.val == num) {
                node.right = node.right.right;
                res = true;
            }
        }
        return res;
    }
}

class Node {
    int val;
    Node right;
    Node down;

    public Node(int val, Node right, Node down) {
        this.val = val;
        this.right = right;
        this.down = down;
    }
}
