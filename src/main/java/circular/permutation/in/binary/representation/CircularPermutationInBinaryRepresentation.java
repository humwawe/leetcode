package circular.permutation.in.binary.representation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class CircularPermutationInBinaryRepresentation {
    boolean[] vis;

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result = new ArrayList<>();
        vis = new boolean[(int) Math.pow(2, n)];
        result.add(start);
        vis[start] = true;
        helper(n, start, result);
        return result;
    }

    private boolean helper(int n, int start, List<Integer> result) {
        if (result.size() == Math.pow(2, n)) {
            int t = result.get(0) ^ result.get(result.size() - 1);
            return (t & (t - 1)) == 0;
        }
        for (int i = 0; i < n; i++) {
            int t = start ^ (1 << i);
            if (vis[t]) {
                continue;
            }
            vis[t] = true;
            result.add(t);
            if (helper(n, t, result)) {
                return true;
            }
            result.remove(result.size() - 1);
            vis[t] = false;
        }
        return false;
    }
}
