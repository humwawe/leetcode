package reverse.integer;

/**
 * @author hum
 */
public class ReverseInteger {
    public int reverse(int x) {
        // 不用判断负数
        int result = 0;
        int temp = 0;
        while (x != 0) {
            temp = result;
            result = result * 10 + x % 10;
            x = x / 10;
            // 溢出的情况
            if (temp != result / 10) {
                return 0;
            }
        }
        return result;
    }
}
