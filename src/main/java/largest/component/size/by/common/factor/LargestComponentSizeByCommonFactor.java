package largest.component.size.by.common.factor;


/**
 * @author hum
 */
public class LargestComponentSizeByCommonFactor {
    int[] p = new int[120005];
    int[] size = new int[120005];

    public int largestComponentSize(int[] a) {
        int len = a.length;
        int max = 100000;
        for (int i = 1; i <= len + max; i++) {
            p[i] = i;
        }
        int result = 0;
        for (int i = 1; i <= len; i++) {
            if (a[i - 1] == 1) {
                continue;
            }
            size[i + max] = 1;
            for (int j = 1; j * j <= a[i - 1]; j++) {
                if (a[i - 1] % j == 0) {
                    if (j != 1) {
                        union(i + max, j);
                    }
                    union(i + max, a[i - 1] / j);
                }
            }
            result = Math.max(result, size[find(i + max)]);
        }

        return result;
    }

    private int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }
        size[find(b)] += size[find(a)];
        p[find(a)] = find(b);
    }
}
