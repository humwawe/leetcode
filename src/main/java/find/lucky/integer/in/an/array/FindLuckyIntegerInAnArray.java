package find.lucky.integer.in.an.array;

/**
 * @author hum
 */
public class FindLuckyIntegerInAnArray {
    public int findLucky(int[] arr) {
        int[] tmp = new int[505];
        for (int i : arr) {
            tmp[i]++;
        }
        int result = -1;
        for (int i = 1; i < 505; i++) {
            if (i == tmp[i]) {
                result = i;
            }
        }
        return result;
    }
}
