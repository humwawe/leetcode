package shuffle.string;

/**
 * @author hum
 */
public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        int len = indices.length;
        char[] tmp = new char[len];
        int i = 0;
        for (int index : indices) {
            tmp[index] = s.charAt(i++);
        }
        return new String(tmp);
    }
}
