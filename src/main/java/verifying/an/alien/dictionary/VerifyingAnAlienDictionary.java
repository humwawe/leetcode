package verifying.an.alien.dictionary;

/**
 * @author hum
 */
public class VerifyingAnAlienDictionary {
    int[] o = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            o[order.charAt(i) - 'a'] = i;
        }
        int len = words.length;
        for (int i = 0; i < len - 1; i++) {
            if (!helper(words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(String i, String j) {
        int index = 0;
        while (index < i.length() && index < j.length()) {
            if (o[i.charAt(index) - 'a'] > o[j.charAt(index) - 'a']) {
                return false;
            } else if (o[i.charAt(index) - 'a'] < o[j.charAt(index) - 'a']) {
                return true;
            } else {
                index++;
            }
        }
        return i.length() <= j.length();
    }
}
