package previous.permutation.with.one.swap;

/**
 * @author hum
 */
public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] a) {
        int len = a.length;
        int l = len - 2;
        while (l >= 0 && a[l] <= a[l + 1]) {
            l--;
        }
        if (l < 0) {
            return a;
        }
        int r = l + 1;
        int index = r;
        int max = a[r];
        while (r < a.length && a[r] < a[l]) {
            if (a[r] > max) {
                index = r;
                max = a[r];
            }
            r++;
        }
        int tmp = a[l];
        a[l] = a[index];
        a[index] = tmp;
        return a;
    }
}
