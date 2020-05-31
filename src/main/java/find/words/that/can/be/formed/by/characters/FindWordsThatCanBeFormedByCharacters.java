package find.words.that.can.be.formed.by.characters;

/**
 * @author hum
 */
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] tmp = new int[26];
        for (char c : chars.toCharArray()) {
            tmp[c - 'a']++;
        }
        int result = 0;
        for (String word : words) {
            int[] t = new int[26];
            boolean f = true;
            for (char c : word.toCharArray()) {
                t[c - 'a']++;
                if (t[c - 'a'] > tmp[c - 'a']) {
                    f = false;
                    break;
                }
            }
            if (f) {
                result += word.length();
            }
        }
        return result;
    }
}
