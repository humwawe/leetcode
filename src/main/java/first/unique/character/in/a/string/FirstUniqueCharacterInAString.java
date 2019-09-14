package first.unique.character.in.a.string;

/**
 * @author hum
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] result = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            result[c - 'a']++;
        }
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (result[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
