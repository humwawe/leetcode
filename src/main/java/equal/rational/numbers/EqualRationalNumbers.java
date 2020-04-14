package equal.rational.numbers;

/**
 * @author hum
 */
public class EqualRationalNumbers {
    public boolean isRationalEqual(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        long[] n1 = analysisFraction(s);
        long[] n2 = analysisFraction(t);
        return n1[0] * n2[1] == n1[1] * n2[0];
    }


    private static long[] analysisFraction(String str) {
        int i = str.indexOf(".");
        if (i < 0) {
            return new long[]{Long.parseLong(str), 1};
        }
        long wholeNumber = Long.parseLong(str.substring(0, i));
        str = str.substring(i + 1);
        int bracketIndex = str.indexOf("(");
        if (bracketIndex < 0) {
            long decimal = str.length() == 0 ? 0L : Long.parseLong(str);
            long denominator = (long) Math.pow(10, str.length());
            return new long[]{wholeNumber * denominator + decimal, denominator};
        }
        String noCycleStr = str.substring(0, bracketIndex);
        long noCycleOffset = (long) Math.pow(10, noCycleStr.length());
        long noCycleNum = (noCycleStr.length() == 0) ? 0L : Long.parseLong(noCycleStr);
        String cycleStr = str.substring(bracketIndex + 1, str.indexOf(")"));
        long cycleOffset = (long) Math.pow(10, cycleStr.length()) - 1;
        long cycleNum = (cycleStr.length() == 0) ? 0L : Long.parseLong(cycleStr);
        long denominator = cycleOffset * noCycleOffset;
        long numerator = wholeNumber * denominator + noCycleNum * cycleOffset + cycleNum;
        return new long[]{numerator, denominator};
    }
}
