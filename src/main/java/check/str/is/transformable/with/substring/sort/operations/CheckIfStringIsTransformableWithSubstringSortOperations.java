package check.str.is.transformable.with.substring.sort.operations;

import java.util.LinkedList;

/**
 * @author hum
 */
public class CheckIfStringIsTransformableWithSubstringSortOperations {
    public boolean isTransformable(String s, String t) {
        int len = s.length();
        LinkedList<Integer>[] lists = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            lists[i] = new LinkedList<>();
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            lists[c - '0'].add(i);
        }
        for (int i = len - 1; i >= 0; i--) {
            int num = t.charAt(i) - '0';
            if (lists[num].isEmpty()) {
                return false;
            }
            int idx = lists[num].removeLast();
            for (int j = num + 1; j < 10; j++) {
                if (lists[j].size() > 0 && lists[j].getLast() > idx) {
                    return false;
                }
            }

        }
        return true;
    }
}
