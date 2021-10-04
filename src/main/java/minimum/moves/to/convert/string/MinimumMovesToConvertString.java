package minimum.moves.to.convert.string;

/**
 * @author hum
 */
public class MinimumMovesToConvertString {
    public int minimumMoves(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'X') {
                res++;
                i += 2;
            }
        }
        return res;
    }
}
