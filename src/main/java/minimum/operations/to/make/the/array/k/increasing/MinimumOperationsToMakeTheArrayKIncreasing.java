package minimum.operations.to.make.the.array.k.increasing;

/**
 * @author hum
 */
public class MinimumOperationsToMakeTheArrayKIncreasing {
    public int kIncreasing(int[] arr, int k) {
        int len = arr.length;
        int res = 0;
        for (int i = 0; i < k; i++) {
            int[] tmp = new int[len / k + 5];
            int idx = 0;
            tmp[idx++] = arr[i];
            int t = 1;
            for (int j = i + k; j < len; j += k) {
                t++;
                if (arr[j] >= tmp[idx - 1]) {
                    tmp[idx++] = arr[j];
                    continue;
                }
                int l = 0;
                int r = idx;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (tmp[mid] <= arr[j]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tmp[l] = arr[j];
            }
            res += t - idx;
        }
        return res;
    }
}
