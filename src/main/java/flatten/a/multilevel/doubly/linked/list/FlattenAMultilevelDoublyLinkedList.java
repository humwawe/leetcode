package flatten.a.multilevel.doubly.linked.list;

import common.MultiDoublyNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FlattenAMultilevelDoublyLinkedList {
    public MultiDoublyNode flatten(MultiDoublyNode head) {
        if (head == null) {
            return null;
        }
        List<MultiDoublyNode> result = new ArrayList<>();
        helper(head, result);
        result.get(0).child = null;
        for (int i = 1; i < result.size(); i++) {
            result.get(i - 1).next = result.get(i);
            result.get(i).prev = result.get(i - 1);
            result.get(i).child = null;
        }
        result.get(result.size() - 1).next = null;
        return result.get(0);
    }

    private void helper(MultiDoublyNode head, List<MultiDoublyNode> result) {
        if (head == null) {
            return;
        }
        result.add(head);
        helper(head.child, result);
        helper(head.next, result);
    }
}
