package largest.time.fo.given.digits;

/**
 * @author hum
 */
public class LargestTimeForGivenDigits {
    String result = "";
    boolean[] vis = new boolean[4];

    public String largestTimeFromDigits(int[] a) {
        helper(a, 0, "");
        if (!result.equals("")) {
            result = result.substring(0, 2) + ":" + result.substring(2);
        }
        return result;
    }

    private void helper(int[] a, int i, String s) {
        if (i == a.length) {
            if (check(s) && s.compareTo(result) > 0) {
                result = s;
            }
        }
        for (int j = 0; j < a.length; j++) {
            if (vis[j]) {
                continue;
            }
            vis[j] = true;
            helper(a, i + 1, s + String.valueOf(a[j]));
            vis[j] = false;
        }
    }

    private boolean check(String s) {
        int a = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
        if (a >= 24) {
            return false;
        }
        a = (s.charAt(2) - '0') * 10 + s.charAt(3) - '0';
        return a < 60;
    }
}
