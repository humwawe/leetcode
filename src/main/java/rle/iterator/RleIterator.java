package rle.iterator;

/**
 * @author hum
 */
public class RleIterator {
    int[] a = new int[1005];
    int[] count = new int[1005];
    int len = 0;
    int i = 0;
    int j = 0;

    public RleIterator(int[] a) {
        for (int i = 0; i < a.length; i += 2) {
            if (a[i] == 0) {
                continue;
            }
            count[len] = a[i];
            this.a[len] = a[i + 1];
            len++;
        }
    }

    public int next(int n) {
        if (i == len) {
            return -1;
        }
        int c = 0;
        c = this.count[i] - j;
        while (i < len && c < n) {
            i++;
            c += this.count[i];
        }
        if (i == len) {
            return -1;
        }
        j = this.count[i] - (c - n);
        return this.a[i];
    }
}
