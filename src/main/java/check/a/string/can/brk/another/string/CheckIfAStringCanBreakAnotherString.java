package check.a.string.can.brk.another.string;

/**
 * @author hum
 */
public class CheckIfAStringCanBreakAnotherString {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] t1 = new int[26];
        int[] t2 = new int[26];
        int[] t3 = new int[26];
        int[] t4 = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            t1[s1.charAt(i) - 'a']++;
            t2[s2.charAt(i) - 'a']++;
            t3[s1.charAt(i) - 'a']++;
            t4[s2.charAt(i) - 'a']++;
        }

        return helper(t1, t2) || helper(t4, t3);
    }

    private boolean helper(int[] t1, int[] t2) {
        int i = 25;
        int j = 25;
        while (j > 0) {
            while (i >= 0 && t1[i] == 0) {
                i--;
            }
            while (j >= 0 && t2[j] == 0) {
                j--;
            }
            if (i < j) {
                return false;
            }
            if (i == -1 || j == -1) {
                return true;
            }
            int count = Math.min(t1[i], t2[j]);
            t1[i] -= count;
            t2[j] -= count;
            if (t1[i] == 0) {
                i--;
            }
            if (t2[j] == 0) {
                j--;
            }
        }
        return true;
    }
}
