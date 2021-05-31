package maximum.value.after.insertion;

/**
 * @author hum
 */
public class MaximumValueAfterInsertion {
    public String maxValue(String n, int x) {
        if (n.charAt(0) == '-') {
            int i = 1;
            while (i < n.length() && n.charAt(i) - '0' <= x) {
                i++;
            }
            return insert(n, i, x);
        } else {
            int i = 0;
            while (i < n.length() && n.charAt(i) - '0' >= x) {
                i++;
            }
            return insert(n, i, x);
        }
    }

    private String insert(String n, int i, int x) {
        return n.substring(0, i) + x + n.substring(i);
    }
}
