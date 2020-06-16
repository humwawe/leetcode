package number.of.operations.to.make.network.connected;

import com.sun.org.apache.bcel.internal.generic.IFNE;

/**
 * @author hum
 */
public class NumberOfOperationsToMakeNetworkConnected {
    int[] p;

    public int makeConnected(int n, int[][] connections) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        int count = 0;
        int size = n;
        for (int[] connection : connections) {
            int a = find(connection[0]);
            int b = find(connection[1]);
            if (a == b) {
                count++;
            } else {
                p[a] = b;
                size--;
            }
        }
        if (size - 1 > count) {
            return -1;
        }
        return size - 1;
    }

    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
