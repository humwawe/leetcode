package jump.game.VII;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        if (s.charAt(len - 1) == '1') {
            return false;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        int max = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (cur == len - 1) {
                return true;
            }
            for (int i = Math.max(max, cur + minJump); i <= Math.min(cur + maxJump, len - 1); i++) {
                if (s.charAt(i) == '0') {
                    queue.add(i);
                }
            }
            max = Math.max(max, cur + maxJump);
        }
        return false;
    }
}
