package reordered.power.of.two;

/**
 * @author hum
 */
public class ReorderedPowerOfTwo {
    public boolean reorderedPowerOf2(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[] vis = new boolean[len];
        return helper(chars, 0, "", vis);
    }

    private boolean helper(char[] chars, int i, String res, boolean[] vis) {
        if (res.length() == chars.length) {
            int tmp = Integer.valueOf(res);
            return (tmp & tmp - 1) == 0;
        }
        Character lastUsed = null;
        for (int j = 0; j < chars.length; j++) {
            if (!vis[j]) {
                if ((i == 0 && chars[j] == '0') || (lastUsed != null && lastUsed == chars[j])) {
                    continue;
                }
                vis[j] = true;
                if (helper(chars, i + 1, res + chars[j], vis)) {
                    return true;
                }
                vis[j] = false;
                lastUsed = chars[j];
            }
        }
        return false;
    }

}
