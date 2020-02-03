package rotated.digits;

/**
 * @author hum
 */
public class RotatedDigits {
    public int rotatedDigits(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (helper(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean helper(int i) {
        boolean flag = false;
        for (char c : String.valueOf(i).toCharArray()) {
            if (c == '3' || c == '4' || c == '7') {
                return false;
            }
            if (c == '2' || c == '5' || c == '6' || c == '9') {
                flag = true;
            }
        }
        return flag;
    }
}
