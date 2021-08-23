package minimum.time.to.type.word.using.special.typewriter;

/**
 * @author hum
 */
public class MinimumTimeToTypeWordUsingSpecialTypewriter {
    public int minTimeToType(String word) {
        char t = 'a';
        int res = 0;
        for (char c : word.toCharArray()) {
            res += Math.min((c - t + 26) % 26, (t - c + 26) % 26);
            t = c;
        }
        return res + word.length();
    }
}
