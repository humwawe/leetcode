package vowels.of.all.substrings;

/**
 * @author hum
 */
public class VowelsOfAllSubstrings {
    public long countVowels(String word) {
        int len = word.length();
        long res = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'i' || c == 'e' || c == 'u' || c == 'o') {
                long pre = i + 1;
                long suf = len - i;
                res += pre * suf;
            }
        }
        return res;
    }
}
