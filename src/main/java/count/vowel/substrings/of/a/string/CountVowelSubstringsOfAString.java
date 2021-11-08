package count.vowel.substrings.of.a.string;

/**
 * @author hum
 */
public class CountVowelSubstringsOfAString {
    public int countVowelSubstrings(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            int num = 0;
            for (int j = i; j < word.length(); j++) {
                char c = word.charAt(j);
                if (c == 'a') {
                    num = (num | 1);
                } else if (c == 'e') {
                    num = num | (1 << 1);
                } else if (c == 'i') {
                    num = num | (1 << 2);
                } else if (c == 'o') {
                    num = num | (1 << 3);
                } else if (c == 'u') {
                    num = num | (1 << 4);
                } else {
                    break;
                }
                if (num == 31) {
                    res++;
                }
            }
        }
        return res;
    }
}
