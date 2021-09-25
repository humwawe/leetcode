package longest.subsequence.repeated.k.times;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class LongestSubsequenceRepeatedKTimes {
    public String longestSubsequenceRepeatedK(String s, int k) {
        String res = "";
        Queue<String> q = new ArrayDeque<>();
        q.add("");
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                for (int i = 0; i < 26; i++) {
                    String next = cur + (char) ('a' + i);
                    if (isSub(s, next, k)) {
                        res = next;
                        q.add(next);
                    }
                }
            }
        }
        return res;
    }

    private boolean isSub(String s, String sub, int k) {
        int j = 0;
        int repeat = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
                if (j == sub.length()) {
                    repeat++;
                    if (repeat == k) {
                        return true;
                    }
                    j = 0;
                }
            }
        }
        return false;
    }


}
