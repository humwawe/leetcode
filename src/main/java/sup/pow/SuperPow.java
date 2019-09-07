package sup.pow;

/**
 * @author hum
 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        int res = 1;
        for (int aB : b) {
            res = pow(res, 10) * pow(a, aB) % 1337;
        }
        return res;
    }

    private int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x % 1337;
        }
        return pow(x % 1337, n / 2) * pow(x % 1337, n - n / 2) % 1337;
    }
}
