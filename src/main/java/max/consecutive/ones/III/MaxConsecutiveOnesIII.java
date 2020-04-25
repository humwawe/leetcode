package max.consecutive.ones.III;

/**
 * @author hum
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] a, int k) {
        int len = a.length;
        int j = 0;
        int count = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (a[i] == 0) {
                count++;
            }
            while (count > k) {
                if (a[j] == 0) {
                    count--;
                }
                j++;
            }
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
