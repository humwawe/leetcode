package median.of.two.sorted.arrays;

/**
 * @author hum
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // 小的为nums1，以移动nums1为参考，保证移动num1时，nums2不会跑出去
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left1 = 0, left2 = 0, right1 = 0, right2 = 0, mid1, mid2;
        // 每个间隙插入虚拟元素，总元素为2n*1（下表为2n），使得每个数组为奇数
        int low = 0, high = 2 * n;
        // 这里同是闭区间，若左闭右开，则考虑循环条件为low<high，重新赋mid也许注意区间
        while (low <= high) {
            mid1 = (low + high) / 2;
            // 分割点mid2跟随mid1变动，mid1按二分边
            mid2 = n + m - mid1;
            // l1,l2,r1,r2的位置应在分割点两侧，始终为数值（不为虚拟点），若分割点切到虚拟数组的数值上，则映射后l，r指向分割点指向的值
            // 若分割点取到最小值或最大值（虚拟点上），l、r本应该分别两侧，用int_min，int_max替代
            left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            right1 = (mid1 == 2 * n) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            right2 = (mid2 == 2 * m) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if (left1 > right2) {
                high = mid1 - 1;
            } else if (left2 > right1) {
                low = mid1 + 1;
            } else {
                break;
            }
        }
        // 简单防溢出，若不为double，这种方法无效，使用a+a-b/2也不行，因为加可能溢出，减也可能溢出（b为负数）
        // 可以采用位运算进行操作或者 a/2 + b/2 + (a%2 + b%2)/2
        return Integer.max(left1, left2) / 2.0 + Integer.min(right1, right2) / 2.0;
    }
}
