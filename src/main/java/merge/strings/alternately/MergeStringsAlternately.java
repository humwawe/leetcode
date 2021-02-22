package merge.strings.alternately;

/**
 * @author hum
 */
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                res.append(word1.charAt(i++));
            }
            if (j < word2.length()) {
                res.append(word2.charAt(j++));
            }
        }
        return res.toString();
    }
}
