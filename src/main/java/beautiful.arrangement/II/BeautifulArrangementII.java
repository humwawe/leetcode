package beautiful.arrangement.II;

/**
 * @author hum
 */
public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        result[0] = 1;
        int index = 1;
        boolean flag = true;
        int start = 2;
        int tail = n;
        int count = k;
        while (count-- > 1) {
            if (flag) {
                result[index++] = tail--;
                flag = false;
            } else {
                result[index++] = start++;
                flag = true;
            }
        }
        while (index < n) {
            if (k % 2 == 0) {
                result[index++] = tail--;
            } else {
                result[index++] = start++;
            }
        }
        return result;
    }
}
