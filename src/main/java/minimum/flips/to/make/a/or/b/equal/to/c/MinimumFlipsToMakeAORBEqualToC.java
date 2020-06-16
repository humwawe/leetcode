package minimum.flips.to.make.a.or.b.equal.to.c;

/**
 * @author hum
 */
public class MinimumFlipsToMakeAORBEqualToC {
    public int minFlips(int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < 31; i++) {
            int t1 = a >> i & 1;
            int t2 = b >> i & 1;
            int t3 = c >> i & 1;
            if (t3 == 0) {
                result += t1 + t2;
            } else {
                if (t1 == 0 && t2 == 0) {
                    result += 1;
                }
            }
        }
        return result;
    }
}
