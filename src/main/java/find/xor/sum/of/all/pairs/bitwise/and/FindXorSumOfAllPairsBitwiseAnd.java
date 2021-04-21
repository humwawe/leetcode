package find.xor.sum.of.all.pairs.bitwise.and;

/**
 * @author hum
 */
public class FindXorSumOfAllPairsBitwiseAnd {
    public int getXORSum(int[] arr1, int[] arr2) {
        int a = 0, b = 0;
        for (int i : arr1) {
            a ^= i;
        }
        for (int i : arr2) {
            b ^= i;
        }
        return a & b;
    }
}
