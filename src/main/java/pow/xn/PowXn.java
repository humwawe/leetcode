package pow.xn;

import permutations.Permutations;

/**
 * @author hum
 */
public class PowXn {
    public double myPow(double x, int n) {
        double result;
        int t;
        if (n == Integer.MIN_VALUE) {
            t = Integer.MAX_VALUE;
            result = x;
        } else {
            t = Math.abs(n);
            result = 1;
        }
        while (0 != t) {
            if ((t & 1) == 1) {
                result *= x;
            }
            t = t >> 1;
            x = x * x;
        }
        return n >= 0 ? result : 1 / result;
    }

    public static void main(String[] args) {
        int x = -1;
        System.out.println(x >> 1);
        System.out.println(x / 2);
    }
}
