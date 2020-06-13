package subtract.the.product.and.sum.of.digits.of.an.integer;

/**
 * @author hum
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        int add = 0, mul = 1;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            add += digit;
            mul *= digit;
        }
        return mul - add;
    }
}
