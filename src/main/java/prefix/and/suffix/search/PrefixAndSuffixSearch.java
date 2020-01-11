package prefix.and.suffix.search;


import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class PrefixAndSuffixSearch {
    Map<String, Integer> map = new HashMap<>();

    public PrefixAndSuffixSearch(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String pref = word.substring(0, j);
                for (int k = word.length(); k >= 0; k--) {
                    String suff = word.substring(k, word.length());
                    map.put(pref + "#" + suff, i);
                }
            }
        }
        System.out.println(map);
    }

    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "#" + suffix, -1);
    }
}
