package vowel.spellchecker;

import java.util.*;

/**
 * @author hum
 */
public class VowelSpellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set1 = new HashSet<>(Arrays.asList(wordlist));

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for (int i = wordlist.length - 1; i >= 0; i--) {
            map1.put(wordlist[i].toLowerCase(), wordlist[i]);
            map2.put(wordlist[i].toLowerCase().replaceAll("a|e|i|o|u", "#"), wordlist[i]);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (set1.contains(queries[i])) {
                result[i] = queries[i];
            } else if (map1.containsKey(queries[i].toLowerCase())) {
                result[i] = map1.get(queries[i].toLowerCase());
            } else {
                result[i] = map2.getOrDefault(queries[i].toLowerCase().replaceAll("a|e|i|o|u", "#"), "");
            }
        }
        return result;
    }
}
