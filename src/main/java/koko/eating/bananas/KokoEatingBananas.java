package koko.eating.bananas;

/**
 * @author hum
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (helper(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int helper(int[] piles, int k) {
        int res = 0;
        for (int pile : piles) {
            res += (pile - 1) / k + 1;
        }
        return res;
    }
}
