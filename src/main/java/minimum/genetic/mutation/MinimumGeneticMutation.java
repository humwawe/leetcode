package minimum.genetic.mutation;

import java.util.*;

/**
 * @author hum
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (start.length() != end.length()) {
            return -1;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < bank.length - 1; i++) {
            for (int j = i + 1; j < bank.length; j++) {
                if (helper(bank[i], bank[j])) {
                    helper2(bank, map, i, j);
                    helper2(bank, map, j, i);
                }
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        for (String aBank : bank) {
            if (helper(start, aBank)) {
                if (end.equals(aBank)) {
                    return 1;
                }
                queue.add(aBank);
                set.add(aBank);
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(end)) {
                    return result;
                }
                List<String> list = map.get(poll);
                if (list == null) {
                    continue;
                }
                for (String s : list) {
                    if (!set.contains(s)) {
                        queue.add(s);
                        set.add(s);
                    }
                }
            }
        }
        return -1;
    }

    private void helper2(String[] bank, Map<String, List<String>> map, int i, int j) {
        if (map.containsKey(bank[i])) {
            map.get(bank[i]).add(bank[j]);
        } else {
            List<String> tmp = new ArrayList<>();
            tmp.add(bank[j]);
            map.put(bank[i], tmp);
        }
    }

    private boolean helper(String i, String j) {
        int count = 0;
        for (int k = 0; k < i.length(); k++) {
            if (i.charAt(k) != j.charAt(k)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }
}
