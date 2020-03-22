package sort.array.by.parity.II;

/**
 * @author hum
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] a) {
        int len = a.length;
        int[] result = new int[len];
        int even = 0;
        int odd = 1;
        for (int i = 0; i < len; i++) {
            if (a[i] % 2 == 0) {
                result[even] = a[i];
                even += 2;
            } else {
                result[odd] = a[i];
                odd += 2;
            }
        }
        return result;
    }
}
