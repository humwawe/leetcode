package a.number.after.a.dou.reversal;

/**
 * @author hum
 */
public class ANumberAfterADouReversal {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }
        String s = String.valueOf(num);
        return s.charAt(s.length() - 1) != '0';
    }
}
