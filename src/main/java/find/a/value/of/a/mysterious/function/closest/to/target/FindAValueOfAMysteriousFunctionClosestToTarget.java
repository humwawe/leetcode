package find.a.value.of.a.mysterious.function.closest.to.target;

/**
 * @author hum
 */
public class FindAValueOfAMysteriousFunctionClosestToTarget {
    public int closestToTarget(int[] arr, int target) {
        int len = arr.length;
        int result = Math.abs(target - arr[0]);
        int j = 0;
        int[] cnt = new int[20];
        int sum = (1 << 20) - 1;
        for (int i = 0; i < len; i++) {
            sum &= arr[i];
            for (int k = 0; k < 20; k++) {
                if (((arr[i] >> k) & 1) == 0) {
                    cnt[k]++;
                }
            }
            result = Math.min(result, Math.abs(target - sum));
            while (sum < target) {
                for (int k = 0; k < 20; k++) {
                    if (((arr[j] >> k) & 1) == 0) {
                        cnt[k]--;
                        if (cnt[k] == 0) {
                            sum |= 1 << k;
                        }
                    }
                }
                j++;
            }
            result = Math.min(result, Math.abs(target - sum));
        }
        return result;
    }
}
