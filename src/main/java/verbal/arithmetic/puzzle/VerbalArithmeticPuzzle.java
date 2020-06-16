package verbal.arithmetic.puzzle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class VerbalArithmeticPuzzle {
    Map<Character, Integer> map = new HashMap<>();
    boolean[] first = new boolean[10];
    int[] leftWei = new int[10];
    int[] rightWei = new int[10];
    int idx = 0;
    boolean[] vis = new boolean[10];

    public boolean isSolvable(String[] words, String result) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, idx++);
                }
            }
            first[map.get(word.charAt(0))] = true;
        }
        for (char c : result.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, idx++);
            }
        }
        first[map.get(result.charAt(0))] = true;

        calWei(words, leftWei);
        calWei(new String[]{result}, rightWei);

        return helper(0, 0, 0);
    }

    private boolean helper(int i, int leftSum, int rightSum) {
        if (i == idx) {
            return leftSum == rightSum;
        }
        for (int j = 0; j <= 9; j++) {
            if (first[i] && j == 0) {
                continue;
            }
            if (vis[j]) {
                continue;
            }
            vis[j] = true;
            if (helper(i + 1, leftSum + j * leftWei[i], rightSum + j * rightWei[i])) {
                return true;
            }
            vis[j] = false;
        }
        return false;
    }

    private void calWei(String[] words, int[] wei) {
        for (String word : words) {
            int base = 1;
            for (int i = word.length() - 1; i >= 0; i--) {
                wei[map.get(word.charAt(i))] += base;
                base *= 10;
            }
        }
    }
}
