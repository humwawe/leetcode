package find.the.difference;

/**
 * @author hum
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] d1 = new int[26];
        int[] d2 = new int[26];
        for (char c : s.toCharArray()) {
            d1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            d2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (d2[i] == d1[i] + 1) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }
}
