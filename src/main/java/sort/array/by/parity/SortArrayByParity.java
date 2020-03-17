package sort.array.by.parity;

/**
 * @author hum
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            while (i < j && a[i] % 2 == 0) {
                i++;
            }
            while (i < j && a[j] % 2 != 0) {
                j--;
            }
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
        return a;
    }
}
