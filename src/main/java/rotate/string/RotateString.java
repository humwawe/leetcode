package rotate.string;

/**
 * @author hum
 */
public class RotateString {
    public boolean rotateString(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        return (a + a).contains(b);
    }
}
