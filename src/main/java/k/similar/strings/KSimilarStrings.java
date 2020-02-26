package k.similar.strings;

import java.util.*;

/**
 * @author hum
 */
public class KSimilarStrings {
    public int kSimilarity(String a, String b) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(a);

        Map<String, Integer> dist = new HashMap<>();
        dist.put(a, 0);

        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s.equals(b)) {
                return dist.get(s);
            }
            for (String t : neighbors(s, b)) {
                if (!dist.containsKey(t)) {
                    dist.put(t, dist.get(s) + 1);
                    queue.offer(t);
                }
            }
        }
        return 0;
    }

    private List<String> neighbors(String s, String target) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < s.length() && s.charAt(i) == target.charAt(i)) {
            i++;
        }
        char[] t = s.toCharArray();
        for (int j = i + 1; j < s.length(); ++j) {
            if (s.charAt(j) == target.charAt(i)) {
                swap(t, i, j);
                ans.add(new String(t));
                swap(t, i, j);
            }
        }
        return ans;
    }

    public void swap(char[] t, int i, int j) {
        char tmp = t[i];
        t[i] = t[j];
        t[j] = tmp;
    }
}
