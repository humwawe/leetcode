package detect.capital;

/**
 * @author hum
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.toLowerCase().equals(word)) {
            return true;
        }
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        String upper = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == upper.charAt(i)) {
                if (i != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
