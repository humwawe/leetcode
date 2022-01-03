package maximum.employees.to.be.invited.to.a.meeting;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class MaximumEmployeesToBeInvitedToAMeeting {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] deg = new int[n];
        for (int w : favorite) {
            ++deg[w];
        }

        int[] maxDepth = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (deg[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ++maxDepth[u];
            int j = favorite[u];
            maxDepth[j] = Math.max(maxDepth[j], maxDepth[u]);
            if (--deg[j] == 0) {
                queue.add(j);
            }
        }

        int maxRingSize = 0;
        int sumChainSize = 0;
        for (int i = 0; i < n; ++i) {
            if (deg[i] == 0) {
                continue;
            }
            deg[i] = 0;
            int ringSize = 1;
            for (int v = favorite[i]; v != i; v = favorite[v]) {
                deg[v] = 0;
                ++ringSize;
            }
            if (ringSize == 2) {
                sumChainSize += maxDepth[i] + maxDepth[favorite[i]] + 2;
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize);
            }
        }
        return Math.max(maxRingSize, sumChainSize);
    }

}
