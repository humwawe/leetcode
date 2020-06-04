package maximum.number.of.balloons;

/**
 * @author hum
 */
public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] res = new int[26];
        for (char c : text.toCharArray()) {
            res[c - 'a']++;
        }
        res['l' - 'a'] /= 2;
        res['o' - 'a'] /= 2;
        int min = Integer.MAX_VALUE;
        String tS = "balon";
        for (char c : tS.toCharArray()) {
            min = Math.min(res[c - 'a'], min);
        }
        return min;
    }
}
