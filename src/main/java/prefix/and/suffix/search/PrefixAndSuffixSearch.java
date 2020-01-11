package prefix.and.suffix.search;


import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class PrefixAndSuffixSearch {
    Map<String, Integer> map = new HashMap<>();

    public PrefixAndSuffixSearch(String[] words) {
        for (int i = 1; i < words.length; i++) {
            String pref = words[i].substring(i);
            for (int j = words.length - 1; j >= 0; j--) {
                String suff = words[i].substring(j, words[i].length());
                map.put(pref + suff, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + suffix, 0);
    }
}
