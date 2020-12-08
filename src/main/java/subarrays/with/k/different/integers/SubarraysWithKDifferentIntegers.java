package subarrays.with.k.different.integers;

/**
 * @author hum
 */
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] a, int k) {
        int len = a.length;
        int[] tmp = new int[len + 1];
        int count = 0;
        int j = 0;
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (tmp[a[i]] == 0) {
                count++;
            }
            tmp[a[i]]++;
            while (count > k) {
                tmp[a[j]]--;
                if (tmp[a[j]] == 0) {
                    count--;
                }
                j++;
            }
            int t = j;
            if (count == k) {
                while (count == k) {
                    tmp[a[t]]--;
                    if (tmp[a[t]] == 0) {
                        count--;
                    }
                    t++;
                    result++;
                }
                result++;
            }
            for (int l = j; l < t; l++) {
                if (tmp[a[l]]++ == 0) {
                    count++;
                }
            }
        }
        return result;
    }


}
