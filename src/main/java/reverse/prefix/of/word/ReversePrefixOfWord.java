package reverse.prefix.of.word;

/**
 * @author hum
 */
public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        int len = word.length();
        int idx = -1;
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) == ch) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return word;
        }
        StringBuilder sb = new StringBuilder(word.substring(0, idx + 1));
        sb.reverse().append(word.substring(idx + 1));
        return sb.toString();

    }
}
