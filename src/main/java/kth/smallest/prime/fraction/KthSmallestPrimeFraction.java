package kth.smallest.prime.fraction;

/**
 * @author hum
 */
public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0, right = 1, mid;
        int p, q;
        int count;
        while (true) {
            count = 0;
            p = 0;
            q = 1;
            mid = (right + left) / 2;
            for (int i = 0, j = i + 1; i < arr.length; i++) {
                while (j < arr.length && arr[i] > mid * arr[j]) {
                    j++;
                }
                count += arr.length - j;
                if (j < arr.length && arr[i] * q > p * arr[j]) {
                    p = arr[i];
                    q = arr[j];
                }
            }
            if (count == k) {
                return new int[]{p, q};
            } else if (count > k) {
                right = mid;
            } else {
                left = mid;
            }
        }
    }
}
