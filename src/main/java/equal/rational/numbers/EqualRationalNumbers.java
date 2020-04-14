package equal.rational.numbers;

/**
 * @author hum
 */
public class EqualRationalNumbers {
    public boolean isRationalEqual(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        long[] n1 = helper(s);
        long[] n2 = helper(t);
        return n1[0] * n2[1] == n1[1] * n2[0];
    }

    private static long[] helper(String str) {
        int i = str.indexOf(".");
        if (i < 0) {
            return new long[]{Long.parseLong(str), 1};
        }
        long n = Long.parseLong(str.substring(0, i));
        str = str.substring(i + 1);
        i = str.indexOf("(");
        if (i < 0) {
            long a = str.length() == 0 ? 0L : Long.parseLong(str);
            long b = (long) Math.pow(10, str.length());
            return new long[]{n * b + a, b};
        }
        str = str.substring(0, i);
        long noCycleOffset = (long) Math.pow(10, str.length());
        long noCycleNum = (str.length() == 0) ? 0L : Long.parseLong(str);
        String cycleStr = str.substring(i + 1, str.indexOf(")"));
        long cycleOffset = (long) Math.pow(10, cycleStr.length()) - 1;
        long cycleNum = (cycleStr.length() == 0) ? 0L : Long.parseLong(cycleStr);

        long b = cycleOffset * noCycleOffset;
        long a = n * b + noCycleNum * cycleOffset + cycleNum;
        return new long[]{a, b};
    }
}
