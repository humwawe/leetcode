package escape.the.ghosts;

/**
 * @author hum
 */
public class EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int tmp = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (tmp <= dist) {
                return false;
            }
        }
        return true;
    }
}
