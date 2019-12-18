package bulb.switcher.II;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author hum
 */
public class BulbSwitcherII {
    public int flipLights(int n, int m) {
        int len = Math.min(n, 6);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append("0");
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(stringBuilder.toString());
        while (!queue.isEmpty() && m-- > 0) {
            int size = queue.size();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                StringBuilder sb = new StringBuilder(poll);
                for (int j = 0; j < len; j++) {
                    sb.setCharAt(j, (char) ('1' - sb.charAt(j) + '0'));
                }
                if (!set.contains(sb.toString())) {
                    set.add(sb.toString());
                    queue.add(sb.toString());
                }
                sb = new StringBuilder(poll);
                for (int j = 0; j < len; j += 2) {
                    sb.setCharAt(j, (char) ('1' - sb.charAt(j) + '0'));
                }
                if (!set.contains(sb.toString())) {
                    set.add(sb.toString());
                    queue.add(sb.toString());
                }
                sb = new StringBuilder(poll);
                for (int j = 1; j < len; j += 2) {
                    sb.setCharAt(j, (char) ('1' - sb.charAt(j) + '0'));
                }
                if (!set.contains(sb.toString())) {
                    set.add(sb.toString());
                    queue.add(sb.toString());
                }
                sb = new StringBuilder(poll);
                for (int j = 0; j < len; j += 3) {
                    sb.setCharAt(j, (char) ('1' - sb.charAt(j) + '0'));
                }
                if (!set.contains(sb.toString())) {
                    set.add(sb.toString());
                    queue.add(sb.toString());
                }
            }
        }
        return queue.size();
    }
}
