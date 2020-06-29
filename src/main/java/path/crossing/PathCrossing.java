package path.crossing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class PathCrossing {
    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();
        int x = 0, y = 0;
        set.add(0);
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                x--;
            } else if (c == 'E') {
                y++;
            } else if (c == 'S') {
                x++;
            } else {
                y--;
            }
            int p = x * 1005 + y;
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
        }
        return false;
    }
}
