package stamping.the.sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class StampingTheSequence {
    public int[] movesToStamp(String stamp, String target) {
        boolean[] visited = new boolean[target.length()];
        char[] arr = target.toCharArray();
        List<Integer> list = new ArrayList<>();
        int matchCount = 0;
        while (matchCount != target.length()) {
            boolean matched = false;
            for (int i = 0; i < arr.length && !matched; ++i) {
                if (visited[i]) {
                    continue;
                }
                if (match(arr, i, stamp)) {
                    matched = true;
                    for (int j = 0; j < stamp.length(); ++j) {
                        if (arr[i + j] != '*') {
                            matchCount++;
                            arr[i + j] = '*';
                        }
                    }
                    visited[i] = true;
                    list.add(i);
                }
            }
            if (!matched) {
                break;
            }
        }
        if (matchCount != target.length()) {
            return new int[]{};
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ret[i] = list.get(list.size() - i - 1);
        }
        return ret;
    }

    private boolean match(char[] arr, int index, String stamp) {
        int i = 0;
        for (; i < stamp.length() && i + index < arr.length; ++i) {
            if (arr[i + index] != stamp.charAt(i) && arr[i + index] != '*') {
                return false;
            }
        }
        return i == stamp.length();
    }
}
