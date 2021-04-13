package sign.of.the.product.of.an.array;

/**
 * @author hum
 */
public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                res *= -1;
            }
        }
        return res;
    }
}
