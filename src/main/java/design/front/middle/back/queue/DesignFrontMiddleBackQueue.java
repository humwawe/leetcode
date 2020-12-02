package design.front.middle.back.queue;

import java.util.LinkedList;

/**
 * @author hum
 */
public class DesignFrontMiddleBackQueue {
    LinkedList<Integer> list;

    public DesignFrontMiddleBackQueue() {
        list = new LinkedList<>();
    }

    public void pushFront(int val) {
        list.addFirst(val);
    }

    public void pushMiddle(int val) {
        int size = list.size();
        list.add(size / 2, val);
    }

    public void pushBack(int val) {
        list.addLast(val);
    }

    public int popFront() {
        if (list.size() == 0) {
            return -1;
        }
        return list.removeFirst();
    }

    public int popMiddle() {
        int size = list.size();
        if (size == 0) {
            return -1;
        }
        return list.remove((size - 1) / 2);
    }

    public int popBack() {
        if (list.size() == 0) {
            return -1;
        }
        return list.removeLast();
    }
}
