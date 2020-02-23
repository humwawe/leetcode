package longest.mountain.in.array;

/**
 * @author hum
 */
public class LongestMountainInArray {
    public int longestMountain(int[] a) {
        int len = a.length;
        int start = -1;
        int flag = 0;
        int result = 0;
        for (int i = 0; i < len - 1; i++) {
            if (a[i] < a[i + 1]) {
                if (flag != 1) {
                    if (flag == 2) {
                        result = Math.max(result, i - start + 1);
                    }
                    start = i;
                }
                flag = 1;
            } else if (a[i] > a[i + 1]) {
                if (flag == 1) {
                    flag = 2;
                }
            } else {
                if (flag == 2) {
                    result = Math.max(result, i - start + 1);
                }
                start = i;
                flag = 0;
            }
        }
        if (start != -1 && flag == 2) {
            result = Math.max(result, len - start);
        }
        return result;
    }
}
