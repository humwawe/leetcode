package unique.number.of.occurrences;


/**
 * @author hum
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int[] c = new int[2005];
        for (int i : arr) {
            c[i + 1000]++;
        }
        boolean[] vis = new boolean[2005];
        for (int i = 0; i < 2005; i++) {
            if (c[i] == 0) {
                continue;
            }
            if (vis[c[i]]) {
                return false;
            }
            vis[c[i]] = true;
        }
        return true;
    }
}
