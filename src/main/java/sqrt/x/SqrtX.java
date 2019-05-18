package sqrt.x;

/**
 * @author hum
 */
public class SqrtX {
    public static int mySqrt(int x) {
        int left = 0;
        int right = 46340;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
