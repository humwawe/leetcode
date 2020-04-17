package string.without.aaa.or.bbb;

/**
 * @author hum
 */
public class StringWithoutAaaOrBbb {
    public String strWithout3a3b(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();
        while (a > 0 || b > 0) {
            if (a > b) {
                if (a-- > 0) {
                    stringBuilder.append('a');
                }
                if (a-- > 0) {
                    stringBuilder.append('a');
                }
                if (b-- > 0) {
                    stringBuilder.append('b');
                }
            } else if (a < b) {
                if (b-- > 0) {
                    stringBuilder.append('b');
                }
                if (b-- > 0) {
                    stringBuilder.append('b');
                }
                if (a-- > 0) {
                    stringBuilder.append('a');
                }
            } else {
                a--;
                b--;
                stringBuilder.append("ab");
            }
        }
        return stringBuilder.toString();
    }
}
