package longer.contiguous.segments.of.ones.than.zeros;

/**
 * @author hum
 */
public class LongerContiguousSegmentsOfOnesThanZeros {
    public boolean checkZeroOnes(String s) {
        int curOne = 0, maxOne = 0;
        int curZero = 0, maxZero = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                curOne++;
                curZero = 0;
            }
            if (c == '0') {
                curZero++;
                curOne = 0;
            }
            maxOne = Math.max(maxOne, curOne);
            maxZero = Math.max(maxZero, curZero);
        }
        return maxOne > maxZero;
    }
}
