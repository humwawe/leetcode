package letter.tile.possibilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class LetterTilePossibilities {
    private int result = 0;

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        int len = chars.length;
        for (int i = 1; i <= len; i++) {
            boolean[] used = new boolean[len];
            helper(chars, i, new ArrayList<>(), used);
        }
        return result;
    }

    private void helper(char[] chars, int level, List<Character> results, boolean[] used) {
        if (results.size() == level) {
            result++;
            return;
        }
        char lastUsed = '#';
        for (int j = 0; j < chars.length; j++) {
            if (!used[j] && chars[j] != lastUsed) {
                results.add(chars[j]);
                used[j] = true;
                helper(chars, level, results, used);
                results.remove(results.size() - 1);
                lastUsed = chars[j];
                used[j] = false;
            }
        }
    }
}
