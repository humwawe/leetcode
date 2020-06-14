package iterator.fo.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class IteratorForCombination {
    List<String> result;
    int size;
    int idx;

    public IteratorForCombination(String characters, int combinationLength) {
        result = new ArrayList<>();
        helper(characters, combinationLength, 0, "");
        size = result.size();
        idx = 0;
    }

    private void helper(String characters, int combinationLength, int i, String res) {
        if (combinationLength == 0) {
            result.add(res);
            return;
        }
        if (i == characters.length()) {
            return;
        }
        helper(characters, combinationLength - 1, i + 1, res + characters.charAt(i));
        helper(characters, combinationLength, i + 1, res);
    }

    public String next() {
        return result.get(idx++);

    }

    public boolean hasNext() {
        return idx < size;
    }
}
