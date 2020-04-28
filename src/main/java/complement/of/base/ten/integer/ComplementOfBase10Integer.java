package complement.of.base.ten.integer;

/**
 * @author hum
 */
public class ComplementOfBase10Integer {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        int a = s.length();
        int b = (int) Math.pow(2, a) - 1;
        return n ^ b;
    }
}
