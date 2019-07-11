package valid.anagram;

/**
 * @author hum
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] table = new char[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            table[c - 'a']--;
            if (table[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
