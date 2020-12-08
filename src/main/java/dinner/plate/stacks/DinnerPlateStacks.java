package dinner.plate.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author hum
 */
public class DinnerPlateStacks {
    Map<Integer, Stack<Integer>> map;
    int head;
    int last;
    int size;
    int cap;


    public DinnerPlateStacks(int capacity) {
        cap = capacity;
        head = 0;
        last = 0;
        size = 0;
        map = new HashMap<>();
    }

    public void push(int val) {
        while (map.containsKey(head) && map.get(head).size() == cap) {
            head++;
        }
        if (!map.containsKey(head)) {
            map.put(head, new Stack<>());
        }
        map.get(head).push(val);
        last = Math.max(last, head);
        size++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        while (last > 0 && map.get(last).isEmpty()) {
            last--;
        }
        size--;
        head = Math.min(head, last);
        return map.get(last).pop();
    }

    public int popAtStack(int index) {
        if (!map.containsKey(index) || map.get(index).isEmpty()) {
            return -1;
        }
        size--;
        head = Math.min(head, index);
        return map.get(index).pop();
    }
}
