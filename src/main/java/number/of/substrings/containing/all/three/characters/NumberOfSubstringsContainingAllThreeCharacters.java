package number.of.substrings.containing.all.three.characters;

/**
 * @author hum
 */
public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int j = 0;
        int[] tmp = new int[3];
        int result = 0;
        for (int i = 0; i < len; i++) {
            tmp[s.charAt(i) - 'a']++;
            while (tmp[0] >= 1 && tmp[1] >= 1 && tmp[2] >= 1) {
                result += len - i;
                tmp[s.charAt(j) - 'a']--;
                j++;
            }
        }
        return result;
    }
}
