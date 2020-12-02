package maximum.repeating.substring;

/**
 * @author hum
 */
public class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        String tmp = word;
        while (sequence.contains(word)) {
            word += tmp;
            res++;
        }
        return res;
    }
}
