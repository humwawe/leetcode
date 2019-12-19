package implement.magic.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class ImplementMagicDictionary {
    Map<Integer, List<String>> buckets;

    public ImplementMagicDictionary() {
        buckets = new HashMap();
    }

    public void buildDict(String[] words) {
        for (String word : words) {
            buckets.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);
        }
    }

    public boolean search(String word) {
        if (!buckets.containsKey(word.length())) {
            return false;
        }
        for (String candidate : buckets.get(word.length())) {
            int mismatch = 0;
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) != candidate.charAt(i)) {
                    if (++mismatch > 1) {
                        break;
                    }
                }
            }
            if (mismatch == 1) {
                return true;
            }
        }
        return false;
    }
}
