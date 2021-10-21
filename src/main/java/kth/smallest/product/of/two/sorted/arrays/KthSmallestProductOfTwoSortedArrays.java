package kth.smallest.product.of.two.sorted.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class KthSmallestProductOfTwoSortedArrays {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        List<Integer> neg1 = new ArrayList<>();
        List<Integer> pos1 = new ArrayList<>();
        List<Integer> neg2 = new ArrayList<>();
        List<Integer> pos2 = new ArrayList<>();
        for (int v : nums1) {
            if (v < 0) {
                neg1.add(v);
            } else {
                pos1.add(v);
            }
        }
        for (int v : nums2) {
            if (v < 0) {
                neg2.add(v);
            } else {
                pos2.add(v);
            }
        }

        long l = (long) -1e10;
        long r = (long) 1e10;
        while (l < r) {
            long mid = (l + r) >> 1;
            long cur = 0;
            for (int i = 0, j = pos2.size() - 1; i < pos1.size(); ++i) {
                while (j >= 0 && (long) pos1.get(i) * pos2.get(j) > mid) {
                    --j;
                }
                cur += j + 1;
            }
            for (int i = 0, j = 0; i < neg1.size(); ++i) {
                while (j < pos2.size() && (long) neg1.get(i) * pos2.get(j) > mid) {
                    ++j;
                }
                cur += pos2.size() - j;
            }
            for (int i = 0, j = 0; i < pos1.size(); ++i) {
                while (j < neg2.size() && (long) pos1.get(i) * neg2.get(j) <= mid) {
                    ++j;
                }
                cur += j;
            }
            for (int i = 0, j = neg2.size() - 1; i < neg1.size(); ++i) {
                while (j >= 0 && (long) neg1.get(i) * neg2.get(j) <= mid) {
                    --j;
                }
                cur += neg2.size() - 1 - j;
            }
            if (cur < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
