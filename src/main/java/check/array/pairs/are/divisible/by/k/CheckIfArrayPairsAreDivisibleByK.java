package check.array.pairs.are.divisible.by.k;

/**
 * @author hum
 */
public class CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        int[] tmp = new int[k];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int a = arr[i] % k;
            if (a < 0) {
                a += k;
            }
            tmp[a]++;
        }
        if (tmp[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (tmp[i] != tmp[k - i]) {
                return false;
            }
        }
        return true;
    }
}
