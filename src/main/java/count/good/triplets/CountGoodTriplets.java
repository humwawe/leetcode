package count.good.triplets;

/**
 * @author hum
 */
public class CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
