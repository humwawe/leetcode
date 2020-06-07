package count.vowels.permutation;

/**
 * @author hum
 */
public class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        int mod = 1000000007;
        for (int x = 2; x <= n; x++) {
            long aTmp = e;
            long eTmp = (a + i) % mod;
            long iTmp = (a + e + o + u) % mod;
            long oTmp = (i + u) % mod;
            long uTmp = a;
            a = aTmp;
            e = eTmp;
            i = iTmp;
            o = oTmp;
            u = uTmp;
        }
        return (int) ((a + e + i + o + u) % mod);
    }
}
