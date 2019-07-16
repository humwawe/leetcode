package first.bad.version;

/**
 * @author hum
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(left + " " + right);
        if (isBadVersion(left)) {
            return left;
        }
        if (isBadVersion(right)) {
            return right;
        }
        return 0;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
    }
}
