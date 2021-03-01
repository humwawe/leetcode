package equal.sum.arrays.with.minimum.number.of.operations;

/**
 * @author hum
 */
public class EqualSumArraysWithMinimumNumberOfOperations {
    public int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];
        for (int i : nums1) {
            cnt1[i]++;
        }
        for (int i : nums2) {
            cnt2[i]++;
        }
        int min1 = len1;
        int max1 = len1 * 6;
        int min2 = len2;
        int max2 = len2 * 6;
        if (max1 < min2 || min1 > max2) {
            return -1;
        }

        int l = Math.max(min1, min2);
        int r = Math.min(max1, max2);
        int res = (int) 1e8;
        for (int i = l; i <= r; i++) {
            res = Math.min(res, helper(cnt1, i) + helper(cnt2, i));
        }
        return res;
    }

    private int helper(int[] cnt, int i) {
        int res = 0;
        int sum = 0;
        for (int j = 1; j <= 6; j++) {
            sum += cnt[j] * j;
        }
        if (sum > i) {
            int tar = sum - i;
            for (int j = 6; j >= 1; j--) {
                if (tar <= cnt[j] * (j - 1)) {
                    res += (tar + j - 2) / (j - 1);
                    break;
                } else {
                    tar -= cnt[j] * (j - 1);
                    res += cnt[j];
                }
            }
        } else if (sum < i) {
            int tar = i - sum;
            for (int j = 1; j <= 6; j++) {
                if (tar <= cnt[j] * (6 - j)) {
                    res += (tar + 5 - j) / (6 - j);
                    break;
                } else {
                    tar -= cnt[j] * (6 - j);
                    res += cnt[j];
                }
            }
        }
        return res;
    }
}
