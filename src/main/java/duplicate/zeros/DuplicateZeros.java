package duplicate.zeros;

/**
 * @author hum
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        int len = arr.length;
        int i = 0;
        while (i + count < len) {
            if (arr[i++] == 0) {
                count++;
            }
        }
        i--;
        int j = len - 1;
        if (count + i + 1 > len) {
            arr[j--] = arr[i--];
            count--;
        }
        while (count > 0) {
            arr[j--] = arr[i];
            if (arr[i] == 0) {
                arr[j--] = arr[i];
                count--;
            }
            i--;
        }
    }
}
